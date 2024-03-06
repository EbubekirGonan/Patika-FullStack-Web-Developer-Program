package dev.patika.vet_management.api;

import dev.patika.vet_management.bussiness.abstracts.IAnimalService;
import dev.patika.vet_management.bussiness.abstracts.IVaccineService;
import dev.patika.vet_management.core.config.modelMapper.IModelMapperService;
import dev.patika.vet_management.core.result.Result;
import dev.patika.vet_management.core.result.ResultWithData;
import dev.patika.vet_management.core.utilities.ResultHelper;
import dev.patika.vet_management.dto.CursorResponse;
import dev.patika.vet_management.dto.request.vaccine.VaccineSaveRequest;
import dev.patika.vet_management.dto.request.vaccine.VaccineUpdateRequest;
import dev.patika.vet_management.dto.response.vaccine.VaccineResponse;
import dev.patika.vet_management.entities.Animal;
import dev.patika.vet_management.entities.Vaccine;
import jakarta.validation.Valid;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.LocalDateTime;

@RestController
@RequestMapping("/v1/vaccines") //endpoint
public class VaccineController {
    private final IVaccineService vaccineService;
    private final IAnimalService animalService;
    private final IModelMapperService modelMapper;

    public VaccineController(IVaccineService vaccineService, IAnimalService animalService, IModelMapperService modelMapper) {
        this.vaccineService = vaccineService;
        this.animalService = animalService;
        this.modelMapper = modelMapper;
    }

    //CRUD

    //for save
    @PostMapping()
    @ResponseStatus(HttpStatus.CREATED)
    public ResultWithData<VaccineResponse> save(@Valid @RequestBody VaccineSaveRequest vaccineSaveRequest) {
        Vaccine vaccine = this.modelMapper.forRequest().map(vaccineSaveRequest, Vaccine.class);

        Animal animal = this.animalService.get(vaccineSaveRequest.getAnimalId());
        vaccine.setAnimal(animal);

        this.vaccineService.save(vaccine);

        return ResultHelper.success(this.modelMapper.forResponse().map(vaccine, VaccineResponse.class));
    }

    // for get by id
    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ResultWithData<VaccineResponse> get(@PathVariable("id") int id) {
        Vaccine vaccine = this.vaccineService.get(id);
        return ResultHelper.success(this.modelMapper.forResponse().map(vaccine, VaccineResponse.class));

    }

    // for update
    @PutMapping()
    @ResponseStatus(HttpStatus.OK)
    public ResultWithData<VaccineResponse> update(@Valid @RequestBody VaccineUpdateRequest vaccineUpdateRequest) {
        Vaccine vaccine = this.modelMapper.forRequest().map(vaccineUpdateRequest, Vaccine.class);

        Animal animal = this.animalService.get(vaccineUpdateRequest.getAnimalId());
        vaccine.setAnimal(animal);

        this.vaccineService.update(vaccine);

        return ResultHelper.success(this.modelMapper.forResponse().map(vaccine, VaccineResponse.class));
    }

    //for delete by id
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Result delete(@PathVariable("id") int id) {
        this.vaccineService.delete(id);
        return ResultHelper.ok();
    }

    //pageable response
    @GetMapping()
    @ResponseStatus(HttpStatus.OK)
    public ResultWithData<CursorResponse<VaccineResponse>> cursor(
            @RequestParam(name = "page", required = false, defaultValue = "0") int page,
            @RequestParam(name = "pageSize", required = false, defaultValue = "10") int pageSize
    ) {
        Page<Vaccine> vaccinePage = this.vaccineService.cursor(page, pageSize);
        Page<VaccineResponse> vaccineResponses = vaccinePage.map(vaccine -> this.modelMapper.forResponse().map(vaccine, VaccineResponse.class));
        return ResultHelper.cursor(vaccineResponses);
    }

    //find vaccines by date between
    @GetMapping("/findByDateBetween")
    @ResponseStatus(HttpStatus.OK)
    public ResultWithData<CursorResponse<VaccineResponse>> findByProtectionStartDateBetween(
            @RequestParam(name = "startDate") LocalDate startDate,
            @RequestParam(name = "endDate") LocalDate endDate,
            @RequestParam(name = "page", required = false, defaultValue = "0") int page,
            @RequestParam(name = "pageSize", required = false, defaultValue = "10") int pageSize
    ) {
        Pageable pageable = PageRequest.of(page, pageSize);
        Page<Vaccine> filteredVaccinesByProtectionStartDate = this.vaccineService.findByProtectionStartDateBetween(startDate, endDate, pageable).get();
        Page<VaccineResponse> vaccineResponses = filteredVaccinesByProtectionStartDate.map(vaccine -> this.modelMapper.forResponse().map(vaccine, VaccineResponse.class));
        return ResultHelper.cursor(vaccineResponses);
    }

    //find vaccines by animal id and optional date between
    @GetMapping("/findByAnimalIdAndDateBetween")
    @ResponseStatus(HttpStatus.OK)
    public ResultWithData<CursorResponse<VaccineResponse>> findByAnimalIdProtectionAndStartDateBetween(
            @RequestParam(name = "animalId") int animalId ,
            @RequestParam(name = "startDate", required = false, defaultValue = "1980-01-01") LocalDate startDate,
            @RequestParam(name = "endDate", required = false, defaultValue = "2080-01-01") LocalDate endDate,
            @RequestParam(name = "page", required = false, defaultValue = "0") int page,
            @RequestParam(name = "pageSize", required = false, defaultValue = "10") int pageSize
    ) {
        Pageable pageable = PageRequest.of(page, pageSize);
        Page<Vaccine> filteredVaccinesByAnimalIdAndProtectionStartDate = this.vaccineService.findByAnimalIdAndProtectionStartDateBetween(animalId, startDate, endDate, pageable).get();
        Page<VaccineResponse> vaccineResponses = filteredVaccinesByAnimalIdAndProtectionStartDate.map(vaccine -> this.modelMapper.forResponse().map(vaccine, VaccineResponse.class));
        return ResultHelper.cursor(vaccineResponses);
    }

}
