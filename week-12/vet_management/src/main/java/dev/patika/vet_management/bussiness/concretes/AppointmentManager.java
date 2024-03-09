package dev.patika.vet_management.bussiness.concretes;

import dev.patika.vet_management.bussiness.abstracts.IAnimalService;
import dev.patika.vet_management.bussiness.abstracts.IAppointmentService;
import dev.patika.vet_management.bussiness.abstracts.IDoctorService;
import dev.patika.vet_management.core.config.modelMapper.IModelMapperService;
import dev.patika.vet_management.core.exception.NotFoundException;
import dev.patika.vet_management.core.utilities.Msg;
import dev.patika.vet_management.dao.AnimalRepo;
import dev.patika.vet_management.dao.AppointmentRepo;
import dev.patika.vet_management.dao.AvailableDateRepo;
import dev.patika.vet_management.dao.DoctorRepo;
import dev.patika.vet_management.dto.request.appointment.AppointmentSaveRequest;
import dev.patika.vet_management.dto.request.appointment.AppointmentUpdateRequest;
import dev.patika.vet_management.dto.response.appointment.AppointmentResponse;
import dev.patika.vet_management.entities.Animal;
import dev.patika.vet_management.entities.Appointment;
import dev.patika.vet_management.entities.AvailableDate;
import dev.patika.vet_management.entities.Doctor;
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
    private final IModelMapperService modelMapper;
    private final DoctorRepo doctorRepo;
    private final AnimalRepo animalRepo;

    public AppointmentManager(AppointmentRepo appointmentRepo, AvailableDateRepo availableDateRepo, IModelMapperService modelMapper, DoctorRepo doctorRepo, AnimalRepo animalRepo) {
        this.appointmentRepo = appointmentRepo;
        this.availableDateRepo = availableDateRepo;
        this.modelMapper = modelMapper;
        this.doctorRepo = doctorRepo;
        this.animalRepo = animalRepo;
    }

    @Override
    public AppointmentResponse save(AppointmentSaveRequest appointmentSaveRequest) {
        if(isDoctorAvailableOnDay(appointmentSaveRequest.getDoctorId(), appointmentSaveRequest.getAppointmentDateTime())){
            if(!existsByDoctorIdAndAppointmentDateTimeBetween(appointmentSaveRequest.getDoctorId(), appointmentSaveRequest.getAppointmentDateTime(), appointmentSaveRequest.getAppointmentDateTime().plusHours(1))){
                Appointment appointment = this.modelMapper.forRequest().map(appointmentSaveRequest, Appointment.class);

                Doctor doctor = this.doctorRepo.findById(appointmentSaveRequest.getDoctorId()).get();
                appointment.setDoctor(doctor);

                Animal animal = this.animalRepo.findById(appointmentSaveRequest.getAnimalId()).get();
                appointment.setAnimal(animal);
                return this.modelMapper.forResponse().map(this.appointmentRepo.save(appointment), AppointmentResponse.class);
            }else {
                throw new NotFoundException("Girilen zaman aralığında doktorun başka bir randevusu vardır.");
            }
        }else {
            throw new NotFoundException("Belirtilen günde belirtilen doktorun uygunluğu bulunmamaktadır.");
        }
    }

    @Override
    public AppointmentResponse update(AppointmentUpdateRequest appointmentUpdateRequest) {
        Appointment appointment = this.modelMapper.forRequest().map(appointmentUpdateRequest, Appointment.class);

        Doctor doctor = this.doctorRepo.findById(appointmentUpdateRequest.getDoctorId()).get();
        appointment.setDoctor(doctor);

        Animal animal = this.animalRepo.findById(appointmentUpdateRequest.getAnimalId()).get();
        appointment.setAnimal(animal);

        return this.modelMapper.forResponse().map(this.appointmentRepo.save(appointment), AppointmentResponse.class);
    }



    @Override
    public AppointmentResponse get(int id) {
        Appointment appointment = this.appointmentRepo.findById(id).orElseThrow(() -> new NotFoundException(Msg.NOT_FOUND));
        return this.modelMapper.forResponse().map(appointment, AppointmentResponse.class);
    }

    @Override
    public boolean delete(int id) {
        this.appointmentRepo.delete(this.appointmentRepo.findById(id).get());
        return true;
    }

    @Override
    public Page<AppointmentResponse> cursor(int page, int pageSize) {
        Pageable pageable = PageRequest.of(page, pageSize);
        Page<Appointment> appointmentPage = this.appointmentRepo.findAll(pageable);
        return appointmentPage.map(appointment ->
                this.modelMapper.forResponse().map(appointment, AppointmentResponse.class));
    }


    @Override
    public boolean existsByDoctorIdAndAppointmentDateTimeBetween(
            int doctorId, LocalDateTime startDateTime, LocalDateTime endDateTime) {
        return this.appointmentRepo.existsByDoctorIdAndAppointmentDateTimeBetween(
                doctorId, startDateTime, endDateTime);
    }

    @Override
    public Page<AppointmentResponse> findByAnimalIdAndAppointmentDateTimeBetween(int animalId, LocalDateTime startDate, LocalDateTime endDate, Pageable pageable) {
        Page<Appointment> appointmentPage = this.appointmentRepo.findByAnimalIdAndAppointmentDateTimeBetween(animalId, startDate, endDate, pageable).get();
        return appointmentPage.map(appointment -> this.modelMapper.forResponse().map(appointment, AppointmentResponse.class));
    }


    @Override
    public Page<AppointmentResponse> findByDoctorIdAndAppointmentDateTimeBetween(int doctorId, LocalDateTime startDate, LocalDateTime endDate, Pageable pageable) {
        Page<Appointment> appointmentPage = this.appointmentRepo.findByDoctorIdAndAppointmentDateTimeBetween(doctorId, startDate, endDate, pageable).get();
        return appointmentPage.map(appointment -> this.modelMapper.forResponse().map(appointment, AppointmentResponse.class));
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
