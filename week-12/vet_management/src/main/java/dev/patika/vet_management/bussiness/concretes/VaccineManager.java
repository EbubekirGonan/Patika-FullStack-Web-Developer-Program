package dev.patika.vet_management.bussiness.concretes;

import dev.patika.vet_management.bussiness.abstracts.IVaccineService;
import dev.patika.vet_management.core.exception.InvalidVaccineException;
import dev.patika.vet_management.core.exception.NotFoundException;
import dev.patika.vet_management.core.utilities.Msg;
import dev.patika.vet_management.dao.VaccineRepo;
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

    public VaccineManager(VaccineRepo vaccineRepo) {
        this.vaccineRepo = vaccineRepo;
    }

    @Override
    public Vaccine save(Vaccine vaccine){
        Optional<Vaccine> animalLatestVaccine = this.findByNameAndCodeAndAnimalId(vaccine.getName(), vaccine.getCode(),vaccine.getAnimal().getId());
        if(animalLatestVaccine.isPresent()){
            if(vaccine.getProtectionStartDate().isBefore(animalLatestVaccine.get().getProtectionFinishDate())){
                throw new InvalidVaccineException("Belirtilen aşının koruma zamanı sürmektedir. Koruma süresi bitmeden aynı aşı yapılamaz.");
            }
        }
        else{
            return this.vaccineRepo.save(vaccine);
        }
        return vaccine;
    }

    @Override
    public Vaccine update(Vaccine vaccine) {
        this.get(vaccine.getId());
        return save(vaccine);
    }

    @Override
    public Vaccine get(int id) {
        return this.vaccineRepo.findById(id).orElseThrow(() -> new NotFoundException(Msg.NOT_FOUND));
    }

    @Override
    public boolean delete(int id) {
        this.vaccineRepo.delete(this.get(id));
        return true;
    }

    @Override
    public Page<Vaccine> cursor(int page, int pageSize) {
        Pageable pageable = PageRequest.of(page, pageSize);
        return this.vaccineRepo.findAll(pageable);
    }

    @Override
    public Optional<Vaccine> findByNameAndCodeAndAnimalId(String name, String code, int animalId) {
        return this.vaccineRepo.findByNameAndCodeAndAnimalId(name, code, animalId);
    }

    @Override
    public Optional<Page<Vaccine>> findByProtectionStartDateBetween(LocalDate startDate, LocalDate endDate, Pageable pageable) {
        return this.vaccineRepo.findByProtectionStartDateBetween(startDate, endDate, pageable);
    }

    @Override
    public Optional<Page<Vaccine>> findByAnimalIdAndProtectionStartDateBetween(int animalId, LocalDate startDate, LocalDate endDate, Pageable pageable) {
        return this.vaccineRepo.findByAnimalIdAndProtectionStartDateBetween(animalId, startDate, endDate, pageable);
    }
/*
    @Override
    public Boolean existsByCodeAndProtectionFinishDateAfter(String vaccineCode, LocalDate protectionStartDate) {
        return this.vaccineRepo.existsByCodeAndProtectionFinishDateAfter(vaccineCode, protectionStartDate);
    }


 */

}
