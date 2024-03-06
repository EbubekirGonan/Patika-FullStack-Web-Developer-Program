package dev.patika.vet_management.bussiness.abstracts;

import dev.patika.vet_management.entities.Appointment;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.time.LocalDateTime;
import java.util.Optional;

public interface IAppointmentService {
    Appointment save(Appointment appointment);
    Appointment update(Appointment appointment);
    Appointment get(int id);
    boolean delete(int id);
    Page<Appointment> cursor(int page, int pageSize);
    boolean existsByDoctorIdAndAppointmentDateTimeBetween(int doctorId, LocalDateTime startDateTime, LocalDateTime endDateTime);
    Optional<Page<Appointment>> findByAnimalIdAndAppointmentDateTimeBetween(int animalId, LocalDateTime startDate, LocalDateTime endDate, Pageable pageable);
    Optional<Page<Appointment>> findByDoctorIdAndAppointmentDateTimeBetween(int doctorId, LocalDateTime startDate, LocalDateTime endDate, Pageable pageable);


}
