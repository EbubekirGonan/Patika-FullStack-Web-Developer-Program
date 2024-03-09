package dev.patika.vet_management.bussiness.abstracts;

import dev.patika.vet_management.dto.request.availableDate.AvailableDateSaveRequest;
import dev.patika.vet_management.dto.request.availableDate.AvailableDateUpdateRequest;
import dev.patika.vet_management.dto.response.availableDate.AvailableDateResponse;
import dev.patika.vet_management.entities.AvailableDate;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

public interface IAvailableDateService {
    AvailableDateResponse save(AvailableDateSaveRequest availableDateSaveRequest);
    AvailableDateResponse update(AvailableDateUpdateRequest availableDateUpdateRequest);
    AvailableDateResponse get(int id);
    boolean delete(int id);
    Page<AvailableDateResponse> cursor(int page, int pageSize);

    boolean existsByDoctorIdAndAvailableDate(int doctorId, LocalDate availableDate);


}
