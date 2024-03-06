package dev.patika.vet_management.dto.response.appointment;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class AppointmentResponse {
    private int id;
    private LocalDateTime appointmentDateTime;
    private int animalId;
    private int doctorId;
}
