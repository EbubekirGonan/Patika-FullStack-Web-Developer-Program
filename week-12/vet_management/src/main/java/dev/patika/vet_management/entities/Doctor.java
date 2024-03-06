package dev.patika.vet_management.entities;

import dev.patika.vet_management.core.BaseEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Doctor extends BaseEntity {
    //declare fields
    @Column(name = "doctor_name", nullable = false)
    private String name;

    @Column(name = "doctor_phone")
    private String phone;

    @Column(name = "doctor_mail", unique = true)
    private String mail;

    @Column(name = "doctor_address")
    private String address;

    @Column(name = "doctor_city")
    private String city;

    @OneToMany(mappedBy = "doctor")
    private List<AvailableDate> availableDateList;

    @OneToMany(mappedBy = "doctor")
    private List<Appointment> appointmentList;


}
