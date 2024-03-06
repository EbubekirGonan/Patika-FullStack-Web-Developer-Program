package dev.patika.vet_management.dao;

import dev.patika.vet_management.entities.Animal;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AnimalRepo extends JpaRepository<Animal, Integer> {
    Page<Animal> findByName(String name, Pageable pageable);
    Optional<Page<Animal>> findByOwnerId(int ownerId, Pageable pageable);
    boolean existsByNameAndOwnerId(String name, int ownerId);
}
