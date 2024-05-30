package dev.patika.vet_management.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import dev.patika.vet_management.core.BaseEntity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "vaccine")
public class Vaccine extends BaseEntity {
    //declare fields
    @Column(name = "vaccine_name")
    private String name;

    @Column(name = "vaccine_code")
    private String code;

    @Column(name = "protection_start_date")
    private LocalDate protectionStartDate;

    @Column(name = "protection_finish_date")
    private LocalDate protectionFinishDate;

    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "vaccine_animal_id", referencedColumnName = "id")
    @JsonIgnore
    private Animal animal;



}
