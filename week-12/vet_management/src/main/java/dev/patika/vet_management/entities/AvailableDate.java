package dev.patika.vet_management.entities;

import dev.patika.vet_management.core.BaseEntity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "available_date")
public class AvailableDate extends BaseEntity {

    //declare fields
    @Column(name = "available_date")
    private LocalDate availableDate;

    @ManyToOne(cascade = CascadeType.REFRESH)
    @JoinColumn(name = "available_date_doctor_id", referencedColumnName = "id")
    private Doctor doctor;

}
