package dev.patika.vet_management.bussiness.concretes;

import dev.patika.vet_management.bussiness.abstracts.IAnimalService;
import dev.patika.vet_management.core.config.modelMapper.IModelMapperService;
import dev.patika.vet_management.core.exception.NotFoundException;
import dev.patika.vet_management.core.utilities.Msg;
import dev.patika.vet_management.dao.AnimalRepo;
import dev.patika.vet_management.dao.CustomerRepo;
import dev.patika.vet_management.dto.request.animal.AnimalSaveRequest;
import dev.patika.vet_management.dto.response.animal.AnimalResponse;
import dev.patika.vet_management.entities.Animal;
import dev.patika.vet_management.entities.Customer;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AnimalManager implements IAnimalService {
    private final AnimalRepo animalRepo;
    private final CustomerRepo customerRepo;
    private final IModelMapperService modelMapper;

    public AnimalManager(AnimalRepo animalRepo, CustomerRepo customerRepo, IModelMapperService modelMapper) {
        this.animalRepo = animalRepo;
        this.customerRepo = customerRepo;
        this.modelMapper = modelMapper;
    }

    @Override
    public Animal save(Animal animal) {
        if(this.existsByNameAndOwnerId(animal.getName(), animal.getOwner().getId())){
            throw new RuntimeException("Aynı isimde sahip ve hayvan ismi bulunmaktadır. Bu hayvan daha önce kaydedilmiş olabilir.");
        }else {
            return this.animalRepo.save(animal);
        }
    }

    @Override
    public Animal update(Animal animal) {
        Animal temporaryAnimal = this.animalRepo.findById(animal.getId()).get();
        if(!(temporaryAnimal.getName().equals(animal.getName()) && temporaryAnimal.getOwner().getId() == animal.getOwner().getId())
                && this.existsByNameAndOwnerId(animal.getName(), animal.getOwner().getId())){
            throw new RuntimeException("Aynı isimde sahip ve hayvan ismi bulunmaktadır. Bu hayvan daha önce kaydedilmiş olabilir.");
        }else {
            return this.animalRepo.save(animal);
        }
    }

    @Override
    public Animal get(int id) {
        return this.animalRepo.findById(id).orElseThrow(() -> new NotFoundException(Msg.NOT_FOUND));
    }

    @Override
    public boolean delete(int id) {
        this.animalRepo.delete(this.get(id));
        return true;
    }

    @Override
    public Page<Animal> cursor(int page, int pageSize) {
        Pageable pageable = PageRequest.of(page, pageSize);
        return this.animalRepo.findAll(pageable);
    }

    @Override
    public Page<Animal> findByName(String name, Pageable pageable) {
        return this.animalRepo.findByName(name, pageable);
    }

    @Override
    public Optional<Page<Animal>> findByOwnerId(int ownerId, Pageable pageable) {
        return this.animalRepo.findByOwnerId(ownerId, pageable);
    }

    @Override
    public boolean existsByNameAndOwnerId(String name, int ownerId) {
        return this.animalRepo.existsByNameAndOwnerId(name, ownerId);
    }


}
