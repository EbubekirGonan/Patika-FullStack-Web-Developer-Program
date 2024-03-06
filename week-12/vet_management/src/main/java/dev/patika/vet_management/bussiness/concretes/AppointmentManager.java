package dev.patika.vet_management.bussiness.concretes;

import dev.patika.vet_management.bussiness.abstracts.IAppointmentService;
import dev.patika.vet_management.core.exception.NotFoundException;
import dev.patika.vet_management.core.utilities.Msg;
import dev.patika.vet_management.dao.AppointmentRepo;
import dev.patika.vet_management.dao.AvailableDateRepo;
import dev.patika.vet_management.dao.DoctorRepo;
import dev.patika.vet_management.entities.Appointment;
import dev.patika.vet_management.entities.AvailableDate;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class AppointmentManager implements IAppointmentService {
    private final AppointmentRepo appointmentRepo;
    private final AvailableDateRepo availableDateRepo;
    private final DoctorRepo doctorRepo;

    public AppointmentManager(AppointmentRepo appointmentRepo, AvailableDateRepo availableDateRepo, DoctorRepo doctorRepo) {
        this.appointmentRepo = appointmentRepo;
        this.availableDateRepo = availableDateRepo;
        this.doctorRepo = doctorRepo;
    }

    @Override
    public Appointment save(Appointment appointment) {
        if(isDoctorAvailableOnDay(appointment.getDoctor().getId(), appointment.getAppointmentDateTime())){
            if(!existsByDoctorIdAndAppointmentDateTimeBetween(appointment.getDoctor().getId(), appointment.getAppointmentDateTime(), appointment.getAppointmentDateTime().plusHours(1))){
                return this.appointmentRepo.save(appointment);
            }else {
                throw new NotFoundException("Girilen zaman aralığında doktorun başka bir randevusu vardır.");
            }
        }else {
            throw new NotFoundException("Belirtilen günde belirtilen doktorun uygunluğu bulunmamaktadır.");
        }
    }

    @Override
    public Appointment update(Appointment appointment) {
        this.get(appointment.getId());
        return this.appointmentRepo.save(appointment);
    }

    @Override
    public Appointment get(int id) {
        return this.appointmentRepo.findById(id).orElseThrow(() -> new NotFoundException(Msg.NOT_FOUND));
    }

    @Override
    public boolean delete(int id) {
        this.appointmentRepo.delete(this.get(id));
        return true;
    }

    @Override
    public Page<Appointment> cursor(int page, int pageSize) {
        Pageable pageable = PageRequest.of(page, pageSize);
        return this.appointmentRepo.findAll(pageable);
    }

    @Override
    public boolean existsByDoctorIdAndAppointmentDateTimeBetween(int doctorId, LocalDateTime startDateTime, LocalDateTime endDateTime) {
        return this.appointmentRepo.existsByDoctorIdAndAppointmentDateTimeBetween(doctorId, startDateTime, endDateTime);
    }

    @Override
    public Optional<Page<Appointment>> findByAnimalIdAndAppointmentDateTimeBetween(int animalId, LocalDateTime startDate, LocalDateTime endDate, Pageable pageable) {

        return this.appointmentRepo.findByAnimalIdAndAppointmentDateTimeBetween(animalId, startDate, endDate, pageable);
    }

    @Override
    public Optional<Page<Appointment>> findByDoctorIdAndAppointmentDateTimeBetween(int doctorId, LocalDateTime startDate, LocalDateTime endDate, Pageable pageable) {
        return this.appointmentRepo.findByDoctorIdAndAppointmentDateTimeBetween(doctorId, startDate, endDate, pageable);
    }

    public boolean isDoctorAvailableOnDay(int doctorId, LocalDateTime appointmentDateTime){
        List<AvailableDate> availableDates = this.availableDateRepo.findByDoctorId(doctorId);
        List<LocalDate> localDateAvailableDays = new ArrayList<>();
        for(AvailableDate d: availableDates){
            localDateAvailableDays.add(d.getAvailableDate());
        }
        LocalDate appointmentDate = appointmentDateTime.toLocalDate();
        return localDateAvailableDays.contains(appointmentDate);
    }
}
