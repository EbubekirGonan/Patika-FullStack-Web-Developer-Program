package dev.patika.vet_management.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import dev.patika.vet_management.core.BaseEntity;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "appointment")
public class Appointment extends BaseEntity {

    //declare fields
    @Column(name = "appointment_date", nullable = false)
    private LocalDateTime appointmentDateTime;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "appointment_date_animal_id", referencedColumnName = "id")
    @JsonIgnore
    private Animal animal;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "appointment_date_doctor_id", referencedColumnName = "id")
    private Doctor doctor;
}
