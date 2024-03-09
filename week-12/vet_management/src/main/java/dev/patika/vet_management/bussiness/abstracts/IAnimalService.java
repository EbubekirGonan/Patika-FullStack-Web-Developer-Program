package dev.patika.vet_management.bussiness.abstracts;

import dev.patika.vet_management.dto.request.animal.AnimalSaveRequest;
import dev.patika.vet_management.dto.request.animal.AnimalUpdateRequest;
import dev.patika.vet_management.dto.response.animal.AnimalResponse;
import dev.patika.vet_management.entities.Animal;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

public interface IAnimalService {
    AnimalResponse save(AnimalSaveRequest animalSaveRequest);
    AnimalResponse update(AnimalUpdateRequest animalUpdateRequest);
    AnimalResponse get(int id);
    boolean delete(int id);
    Page<AnimalResponse> cursor(int page, int pageSize);
    Page<AnimalResponse> findByName(String name, Pageable pageable);
    Page<AnimalResponse> findByOwnerId(int ownerId, Pageable pageable);
    boolean existsByNameAndOwnerId(String name, int ownerId);


}
