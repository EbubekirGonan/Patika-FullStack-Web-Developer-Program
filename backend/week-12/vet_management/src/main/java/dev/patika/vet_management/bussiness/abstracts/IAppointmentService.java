package dev.patika.vet_management.bussiness.abstracts;

import dev.patika.vet_management.dto.request.appointment.AppointmentSaveRequest;
import dev.patika.vet_management.dto.request.appointment.AppointmentUpdateRequest;
import dev.patika.vet_management.dto.response.appointment.AppointmentResponse;
import dev.patika.vet_management.entities.Appointment;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.time.LocalDateTime;
import java.util.Optional;

public interface IAppointmentService {
    AppointmentResponse save(AppointmentSaveRequest appointmentSaveRequest);
    AppointmentResponse update(AppointmentUpdateRequest appointmentUpdateRequest);
    AppointmentResponse get(int id);
    boolean delete(int id);
    Page<AppointmentResponse> cursor(int page, int pageSize);
    boolean existsByDoctorIdAndAppointmentDateTimeBetween(int doctorId, LocalDateTime startDateTime, LocalDateTime endDateTime);
    Page<AppointmentResponse> findByAnimalIdAndAppointmentDateTimeBetween(int animalId, LocalDateTime startDate, LocalDateTime endDate, Pageable pageable);
    Page<AppointmentResponse> findByDoctorIdAndAppointmentDateTimeBetween(int doctorId, LocalDateTime startDate, LocalDateTime endDate, Pageable pageable);

}
