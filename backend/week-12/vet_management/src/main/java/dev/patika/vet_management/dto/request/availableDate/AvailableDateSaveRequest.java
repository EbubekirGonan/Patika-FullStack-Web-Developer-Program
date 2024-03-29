package dev.patika.vet_management.dto.request.availableDate;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AvailableDateSaveRequest {
    private LocalDate availableDate;
    private int doctorId;
}
