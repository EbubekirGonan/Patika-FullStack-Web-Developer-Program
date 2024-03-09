package dev.patika.vet_management.bussiness.abstracts;

import dev.patika.vet_management.dto.request.vaccine.VaccineSaveRequest;
import dev.patika.vet_management.dto.request.vaccine.VaccineUpdateRequest;
import dev.patika.vet_management.dto.response.vaccine.VaccineResponse;
import dev.patika.vet_management.entities.Vaccine;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Optional;

public interface IVaccineService {
    VaccineResponse save(VaccineSaveRequest vaccineSaveRequest);
    VaccineResponse update(VaccineUpdateRequest vaccineUpdateRequest);
    VaccineResponse get(int id);
    boolean delete(int id);
    Page<VaccineResponse> cursor(int page, int pageSize);
    Optional<Vaccine> findByNameAndCodeAndAnimalId(String name, String code, int animalId);
    //Boolean existsByCodeAndProtectionFinishDateAfter(String vaccineCode, LocalDate protectionStartDate);

    Page<VaccineResponse> findByProtectionStartDateBetween(LocalDate startDate, LocalDate endDate, Pageable pageable);

    Page<VaccineResponse> findByAnimalIdAndProtectionStartDateBetween(int animalId, LocalDate startDate, LocalDate endDate, Pageable pageable);




}
