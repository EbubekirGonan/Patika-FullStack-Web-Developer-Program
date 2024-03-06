package dev.patika.vet_management.dao;

import dev.patika.vet_management.entities.AvailableDate;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

@Repository
public interface AvailableDateRepo extends JpaRepository<AvailableDate, Integer> {
    //@Query(value = "SELECT available_date FROM public.available_date a WHERE a.available_date_doctor_id = ?1",
    //nativeQuery = true)
    List<AvailableDate> findByDoctorId(int doctorId);
    boolean existsByDoctorIdAndAvailableDate(int doctorId, LocalDate availableDate);
}
