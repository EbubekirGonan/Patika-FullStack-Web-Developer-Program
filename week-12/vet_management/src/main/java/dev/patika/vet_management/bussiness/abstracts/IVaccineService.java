package dev.patika.vet_management.bussiness.abstracts;

import dev.patika.vet_management.entities.Vaccine;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Optional;

public interface IVaccineService {
    Vaccine save(Vaccine vaccine);
    Vaccine update(Vaccine vaccine);
    Vaccine get(int id);
    boolean delete(int id);
    Page<Vaccine> cursor(int page, int pageSize);
    Optional<Vaccine> findByNameAndCodeAndAnimalId(String name, String code, int animalId);
    //Boolean existsByCodeAndProtectionFinishDateAfter(String vaccineCode, LocalDate protectionStartDate);

    Optional<Page<Vaccine>> findByProtectionStartDateBetween(LocalDate startDate, LocalDate endDate, Pageable pageable);

    Optional<Page<Vaccine>> findByAnimalIdAndProtectionStartDateBetween(int animalId, LocalDate startDate, LocalDate endDate, Pageable pageable);




}
