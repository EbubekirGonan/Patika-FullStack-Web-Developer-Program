package dev.patika.vet_management.dao;

import dev.patika.vet_management.entities.Appointment;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.Optional;

@Repository
public interface AppointmentRepo extends JpaRepository<Appointment, Integer> {
    boolean existsByDoctorIdAndAppointmentDateTimeBetween(int doctorId, LocalDateTime startDateTime, LocalDateTime endDateTime);

    Optional<Page<Appointment>> findByAnimalIdAndAppointmentDateTimeBetween(int animalId, LocalDateTime startDate, LocalDateTime endDate, Pageable pageable);
    Optional<Page<Appointment>> findByDoctorIdAndAppointmentDateTimeBetween(int doctorId, LocalDateTime startDate, LocalDateTime endDate, Pageable pageable);

}
