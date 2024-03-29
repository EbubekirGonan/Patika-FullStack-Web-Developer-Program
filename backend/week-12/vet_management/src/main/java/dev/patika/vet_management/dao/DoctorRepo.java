package dev.patika.vet_management.dao;

import dev.patika.vet_management.entities.Doctor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface DoctorRepo extends JpaRepository<Doctor, Integer> {
    boolean existsByMail(String mail);
}
