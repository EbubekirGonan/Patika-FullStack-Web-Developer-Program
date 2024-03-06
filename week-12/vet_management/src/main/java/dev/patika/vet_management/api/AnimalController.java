package dev.patika.vet_management.api;

import dev.patika.vet_management.bussiness.abstracts.IAnimalService;
import dev.patika.vet_management.bussiness.abstracts.ICustomerService;
import dev.patika.vet_management.core.config.modelMapper.IModelMapperService;
import dev.patika.vet_management.core.result.Result;
import dev.patika.vet_management.core.result.ResultWithData;
import dev.patika.vet_management.core.utilities.ResultHelper;
import dev.patika.vet_management.dto.CursorResponse;
import dev.patika.vet_management.dto.request.animal.AnimalSaveRequest;
import dev.patika.vet_management.dto.request.animal.AnimalUpdateRequest;
import dev.patika.vet_management.dto.response.animal.AnimalResponse;
import dev.patika.vet_management.entities.Animal;
import dev.patika.vet_management.entities.Customer;
import jakarta.validation.Valid;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/v1/animals") //endpoint
public class AnimalController {
    private final IAnimalService animalService;
    private final ICustomerService customerService;
    private final IModelMapperService modelMapper;

    public AnimalController(IAnimalService animalService, ICustomerService customerService, IModelMapperService modelMapper) {
        this.animalService = animalService;
        this.customerService = customerService;
        this.modelMapper = modelMapper;
    }

    //CRUD
    // for save
    @PostMapping()
    @ResponseStatus(HttpStatus.CREATED)
    public ResultWithData<AnimalResponse> save(@Valid @RequestBody AnimalSaveRequest animalSaveRequest) {
        Animal animal = this.modelMapper.forRequest().map(animalSaveRequest, Animal.class);

        Customer customer = this.customerService.get(animalSaveRequest.getOwnerId());
        animal.setOwner(customer);

        this.animalService.save(animal);
        return ResultHelper.success(this.modelMapper.forResponse().map(animal, AnimalResponse.class));
    }

    //for get by id
    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ResultWithData<AnimalResponse> get(@PathVariable("id") int id) {
        Animal animal = this.animalService.get(id);
        return ResultHelper.success(this.modelMapper.forResponse().map(animal, AnimalResponse.class));
    }

    //for update
    @PutMapping()
    @ResponseStatus(HttpStatus.OK)
    public ResultWithData<AnimalResponse> update(@Valid @RequestBody AnimalUpdateRequest animalUpdateRequest) {
        Animal animal = this.modelMapper.forRequest().map(animalUpdateRequest, Animal.class);

        Customer customer = this.customerService.get(animalUpdateRequest.getOwnerId());
        animal.setOwner(customer);

        this.animalService.update(animal);
        return ResultHelper.success(this.modelMapper.forResponse().map(animal, AnimalResponse.class));
    }

    //for delete by id
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Result delete(@PathVariable("id") int id) {
        this.animalService.delete(id);
        return ResultHelper.ok();
    }

    //pageable repsonse
    @GetMapping()
    @ResponseStatus(HttpStatus.OK)
    public ResultWithData<CursorResponse<AnimalResponse>> cursor(
            @RequestParam(name = "page", required = false, defaultValue = "0") int page,
            @RequestParam(name = "pageSize", required = false, defaultValue = "10") int pageSize
    ) {
        Page<Animal> animalPage = this.animalService.cursor(page, pageSize);
        Page<AnimalResponse> animalResponses = animalPage.map(animal -> this.modelMapper.forResponse().map(animal, AnimalResponse.class));
        return ResultHelper.cursor(animalResponses);
    }


    //for find by animal name
    @GetMapping("/findByAnimalName")
    @ResponseStatus(HttpStatus.OK)
    public ResultWithData<CursorResponse<AnimalResponse>> findByName(
            @RequestParam String name,
            @RequestParam(required = false, defaultValue = "0") int page,
            @RequestParam(required = false, defaultValue = "10") int pageSize
    ) {
        Pageable pageable = PageRequest.of(page, pageSize);
        Page<Animal> filteredAnimals = this.animalService.findByName(name, pageable);
        Page<AnimalResponse> animalResponses = filteredAnimals.map(animal -> this.modelMapper.forResponse().map(animal, AnimalResponse.class));
        return ResultHelper.cursor(animalResponses);
    }

    //for find by owner id
    @GetMapping("/findByOwnerId")
    @ResponseStatus(HttpStatus.OK)
    public ResultWithData<CursorResponse<AnimalResponse>> findByOwnerId(
            @RequestParam int ownerId,
            @RequestParam(required = false, defaultValue = "0") int page,
            @RequestParam(required = false, defaultValue = "10") int pageSize
    ) {
        Pageable pageable = PageRequest.of(page, pageSize);
        Page<Animal> filteredAnimals = this.animalService.findByOwnerId(ownerId, pageable).get();
        Page<AnimalResponse> animalResponses = filteredAnimals.map(animal -> this.modelMapper.forResponse().map(animal, AnimalResponse.class));
        return ResultHelper.cursor(animalResponses);
    }
}
