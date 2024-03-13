package dev.patika.vet_management.dao;

import dev.patika.vet_management.entities.Vaccine;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.Optional;

@Repository
public interface VaccineRepo extends JpaRepository<Vaccine, Integer> {
    @Query(
            value = "SELECT * FROM public.vaccine v WHERE v.vaccine_name = ?1 AND v.vaccine_code = ?2 AND v.vaccine_animal_id = ?3 ORDER BY id DESC LIMIT 1",
            nativeQuery = true
    )
    Optional<Vaccine> findByNameAndCodeAndAnimalId(String name, String code, int animalId);

    Optional<Page<Vaccine>> findByProtectionStartDateBetween(LocalDate startDate, LocalDate endDate, Pageable pageable);
    Optional<Page<Vaccine>> findByAnimalIdAndProtectionStartDateBetween(int animalId, LocalDate startDate, LocalDate endDate, Pageable pageable);



}
