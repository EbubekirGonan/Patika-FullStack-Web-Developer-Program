package dev.patika.vet_management.bussiness.concretes;

import dev.patika.vet_management.bussiness.abstracts.IAnimalService;
import dev.patika.vet_management.core.config.modelMapper.IModelMapperService;
import dev.patika.vet_management.core.exception.NotFoundException;
import dev.patika.vet_management.core.utilities.Msg;
import dev.patika.vet_management.dao.AnimalRepo;
import dev.patika.vet_management.dao.CustomerRepo;
import dev.patika.vet_management.dto.request.animal.AnimalSaveRequest;
import dev.patika.vet_management.dto.request.animal.AnimalUpdateRequest;
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
    public AnimalResponse save(AnimalSaveRequest animalSaveRequest) {
        Animal animal = this.modelMapper.forRequest().map(animalSaveRequest, Animal.class);

        if(this.existsByNameAndOwnerId(animalSaveRequest.getName(), animalSaveRequest.getOwnerId())){
            throw new RuntimeException("Aynı isimde sahip ve hayvan ismi bulunmaktadır. Bu hayvan daha önce kaydedilmiş olabilir.");
        }else {

            Customer customer = this.customerRepo.findById(animalSaveRequest.getOwnerId()).orElseThrow(() -> new NotFoundException("Hayvan sahibi bulunamadı."));
            animal.setOwner(customer);

            return this.modelMapper.forResponse().map(this.animalRepo.save(animal), AnimalResponse.class);
        }
    }


    @Override
    public AnimalResponse update(AnimalUpdateRequest animalUpdateRequest) {
        Animal temporaryAnimal = this.animalRepo.findById(animalUpdateRequest.getId()).get();
        if(!(temporaryAnimal.getName().equals(animalUpdateRequest.getName()) && temporaryAnimal.getOwner().getId() == animalUpdateRequest.getOwnerId())
                && this.existsByNameAndOwnerId(animalUpdateRequest.getName(), animalUpdateRequest.getOwnerId())){
            throw new RuntimeException("Aynı isimde sahip ve hayvan ismi bulunmaktadır. Bu hayvan daha önce kaydedilmiş olabilir.");
        }else {
            Animal animal = this.modelMapper.forRequest().map(animalUpdateRequest, Animal.class);

            Customer customer = this.customerRepo.findById(animalUpdateRequest.getOwnerId()).orElseThrow(() -> new NotFoundException("Hayvan sahibi bulunamadı."));
            animal.setOwner(customer);

            return this.modelMapper.forResponse().map(this.animalRepo.save(animal), AnimalResponse.class);
        }
    }

    @Override
    public AnimalResponse get(int id) {
        Animal animal = this.animalRepo.findById(id).orElseThrow(() -> new NotFoundException(Msg.NOT_FOUND));
        return this.modelMapper.forResponse().map(animal, AnimalResponse.class);
    }

    @Override
    public boolean delete(int id) {
        this.animalRepo.delete(this.animalRepo.findById(id).orElseThrow(() -> new NotFoundException("Kullanıcı bulunamadı")));
        return true;
    }

    @Override
    public Page<AnimalResponse> cursor(int page, int pageSize) {
        Pageable pageable = PageRequest.of(page, pageSize);
        Page<Animal> animalPage = this.animalRepo.findAll(pageable);
        return animalPage.map(animal -> this.modelMapper.forResponse().map(animal, AnimalResponse.class));
    }

    @Override
    public Page<AnimalResponse> findByName(String name, Pageable pageable) {
        Page<Animal> animalPage = this.animalRepo.findByName(name, pageable);
        return animalPage.map(animal -> this.modelMapper.forResponse().map(animal, AnimalResponse.class));
    }

    @Override
    public Page<AnimalResponse> findByOwnerId(int ownerId, Pageable pageable) {
        Page<Animal> animalPage = this.animalRepo.findByOwnerId(ownerId, pageable).get();
        return animalPage.map(animal -> this.modelMapper.forResponse().map(animal, AnimalResponse.class));
    }

    @Override
    public boolean existsByNameAndOwnerId(String name, int ownerId) {
        return this.animalRepo.existsByNameAndOwnerId(name, ownerId);
    }


}
