package dev.patika.vet_management.dto.request.appointment;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class AppointmentUpdateRequest {
    private int id;
    private LocalDateTime appointmentDateTime;
    private int animalId;
    private int doctorId;
}
