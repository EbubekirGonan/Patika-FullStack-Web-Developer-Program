package dev.patika.vet_management.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import dev.patika.vet_management.core.BaseEntity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "animal")
public class Animal extends BaseEntity {

    //declare fields
    @Column(name = "animal_name", nullable = false)
    private String name;

    @Column(name = "animal_species")
    private String species;

    @Column(name = "animal_breed")
    private String breed;

    @Column(name = "animal_gender")
    private String gender;

    @Column(name = "animal_color")
    private String color;

    @Column(name = "animal_dateOfBirth")
    private LocalDate dateOfBirth;

    //join column
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "animal_owner_id", referencedColumnName = "id")
    @JsonIgnore
    private Customer owner;

    @OneToMany(mappedBy = "animal", fetch = FetchType.LAZY, cascade = CascadeType.REMOVE)
    @JsonIgnore //To avoid going into an infinite loop, json ignore
    private List<Vaccine> vaccineList;

    @OneToMany(mappedBy = "animal", fetch = FetchType.LAZY)
    @JsonIgnore
    private List<Appointment> appointmentList;



}
