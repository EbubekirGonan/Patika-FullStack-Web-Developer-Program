package dev.patika.vet_management.bussiness.concretes;

import dev.patika.vet_management.bussiness.abstracts.IVaccineService;
import dev.patika.vet_management.core.config.modelMapper.IModelMapperService;
import dev.patika.vet_management.core.exception.InvalidVaccineException;
import dev.patika.vet_management.core.exception.NotFoundException;
import dev.patika.vet_management.core.utilities.Msg;
import dev.patika.vet_management.dao.AnimalRepo;
import dev.patika.vet_management.dao.VaccineRepo;
import dev.patika.vet_management.dto.request.vaccine.VaccineSaveRequest;
import dev.patika.vet_management.dto.request.vaccine.VaccineUpdateRequest;
import dev.patika.vet_management.dto.response.vaccine.VaccineResponse;
import dev.patika.vet_management.entities.Animal;
import dev.patika.vet_management.entities.Vaccine;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Optional;

@Service

public class VaccineManager implements IVaccineService {
    private final VaccineRepo vaccineRepo;
    private final IModelMapperService modelMapper;
    private final AnimalRepo animalRepo;

    public VaccineManager(VaccineRepo vaccineRepo, IModelMapperService modelMapper, AnimalRepo animalRepo) {
        this.vaccineRepo = vaccineRepo;
        this.modelMapper = modelMapper;
        this.animalRepo = animalRepo;
    }

    @Override
    public VaccineResponse save(VaccineSaveRequest vaccineSaveRequest) {
        Vaccine vaccine = this.modelMapper.forRequest().map(vaccineSaveRequest, Vaccine.class);

        Optional<Vaccine> animalLatestVaccine = this.findByNameAndCodeAndAnimalId(vaccineSaveRequest.getName(), vaccineSaveRequest.getCode(), vaccineSaveRequest.getAnimalId());

        if (animalLatestVaccine.isPresent() && vaccine.getProtectionStartDate().isBefore(animalLatestVaccine.get().getProtectionFinishDate())) {
            throw new InvalidVaccineException("Belirtilen aşının koruma zamanı sürmektedir. Koruma süresi bitmeden aynı aşı yapılamaz.");
        } else {
            Animal animal = this.animalRepo.findById(vaccineSaveRequest.getAnimalId()).get();
            vaccine.setAnimal(animal);
            return this.modelMapper.forResponse().map(this.vaccineRepo.save(vaccine), VaccineResponse.class);
        }
    }


    @Override
    public VaccineResponse update(VaccineUpdateRequest vaccineUpdateRequest) {
        Vaccine vaccine = this.modelMapper.forRequest().map(vaccineUpdateRequest, Vaccine.class);

        Animal animal = this.animalRepo.findById(vaccineUpdateRequest.getAnimalId()).get();
        vaccine.setAnimal(animal);

        return this.modelMapper.forResponse().map(this.vaccineRepo.save(vaccine), VaccineResponse.class);
    }

    @Override
    public VaccineResponse get(int id) {
        Vaccine vaccine = this.vaccineRepo.findById(id).orElseThrow(() -> new NotFoundException(Msg.NOT_FOUND));
        return this.modelMapper.forResponse().map(vaccine, VaccineResponse.class);
    }

    @Override
    public boolean delete(int id) {
        this.vaccineRepo.delete(this.vaccineRepo.findById(id).get());
        return true;
    }

    @Override
    public Page<VaccineResponse> cursor(int page, int pageSize) {
        Pageable pageable = PageRequest.of(page, pageSize);
        Page<Vaccine> vaccinePage = this.vaccineRepo.findAll(pageable);
        return vaccinePage.map(vaccine -> this.modelMapper.forResponse().map(vaccine, VaccineResponse.class));
    }

    @Override
    public Optional<Vaccine> findByNameAndCodeAndAnimalId(String name, String code, int animalId) {
        return this.vaccineRepo.findByNameAndCodeAndAnimalId(name, code, animalId);
    }

    @Override
    public Page<VaccineResponse> findByProtectionStartDateBetween(LocalDate startDate, LocalDate endDate, Pageable pageable) {
        Page<Vaccine> vaccinePage = this.vaccineRepo.findByProtectionStartDateBetween(startDate, endDate, pageable).get();
        return vaccinePage.map(vaccine -> this.modelMapper.forResponse().map(vaccine, VaccineResponse.class));
    }

    @Override
    public Page<VaccineResponse> findByAnimalIdAndProtectionStartDateBetween(int animalId, LocalDate startDate, LocalDate endDate, Pageable pageable) {
        Page<Vaccine> vaccinePage = this.vaccineRepo.findByAnimalIdAndProtectionStartDateBetween(animalId, startDate, endDate, pageable).get();
        return vaccinePage.map(vaccine -> this.modelMapper.forResponse().map(vaccine, VaccineResponse.class));
    }
}
