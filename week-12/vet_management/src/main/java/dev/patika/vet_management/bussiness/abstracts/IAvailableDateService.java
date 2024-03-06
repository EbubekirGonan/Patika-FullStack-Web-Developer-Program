package dev.patika.vet_management.bussiness.abstracts;

import dev.patika.vet_management.entities.AvailableDate;
import org.springframework.data.domain.Page;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

public interface IAvailableDateService {
    AvailableDate save(AvailableDate availableDate);
    AvailableDate update(AvailableDate availableDate);
    AvailableDate get(int id);
    boolean delete(int id);
    Page<AvailableDate> cursor(int page, int pageSize);
    List<AvailableDate> findByDoctorId(int doctorId);
    boolean existsByDoctorIdAndAvailableDate(int doctorId, LocalDate availableDate);


}
