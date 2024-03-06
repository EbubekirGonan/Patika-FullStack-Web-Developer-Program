package dev.patika.vet_management.bussiness.abstracts;

import dev.patika.vet_management.dto.request.animal.AnimalSaveRequest;
import dev.patika.vet_management.dto.response.animal.AnimalResponse;
import dev.patika.vet_management.entities.Animal;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

public interface IAnimalService {
    Animal save(Animal animal);
    Animal update(Animal animal);
    Animal get(int id);
    boolean delete(int id);
    Page<Animal> cursor(int page, int pageSize);
    Page<Animal> findByName(String name, Pageable pageable);
    Optional<Page<Animal>> findByOwnerId(int ownerId, Pageable pageable);
    boolean existsByNameAndOwnerId(String name, int ownerId);


}
