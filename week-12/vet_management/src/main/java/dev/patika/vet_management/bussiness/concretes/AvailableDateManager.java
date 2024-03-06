package dev.patika.vet_management.bussiness.concretes;

import dev.patika.vet_management.bussiness.abstracts.IAvailableDateService;
import dev.patika.vet_management.core.exception.NotFoundException;
import dev.patika.vet_management.core.utilities.Msg;
import dev.patika.vet_management.dao.AvailableDateRepo;
import dev.patika.vet_management.entities.AvailableDate;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class AvailableDateManager implements IAvailableDateService {
    private final AvailableDateRepo availableDateRepo;

    public AvailableDateManager(AvailableDateRepo availableDateRepo) {
        this.availableDateRepo = availableDateRepo;
    }

    @Override
    public AvailableDate save(AvailableDate availableDate) {
        if(this.existsByDoctorIdAndAvailableDate(availableDate.getDoctor().getId(), availableDate.getAvailableDate())){
            throw new RuntimeException("Belirtilen doktorun takvimine belirtilen gün daha önce eklenmiştir. Lütfen başka bir gün seçiniz.");
        }else {
            return this.availableDateRepo.save(availableDate);
        }
    }

    @Override
    public AvailableDate update(AvailableDate availableDate) {
        if(this.existsByDoctorIdAndAvailableDate(availableDate.getDoctor().getId(), availableDate.getAvailableDate())){
            throw new RuntimeException("Belirtilen doktorun takvimine belirtilen gün daha önce eklenmiştir. Lütfen başka bir gün seçiniz.");
        }else {
            return this.availableDateRepo.save(availableDate);
        }
    }

    @Override
    public AvailableDate get(int id) {
        return this.availableDateRepo.findById(id).orElseThrow(() -> new NotFoundException(Msg.NOT_FOUND));
    }

    @Override
    public boolean delete(int id) {
        this.availableDateRepo.delete(this.get(id));
        return true;
    }

    @Override
    public Page<AvailableDate> cursor(int page, int pageSize) {
        Pageable pageable = PageRequest.of(page, pageSize);
        return this.availableDateRepo.findAll(pageable);
    }

    @Override
    public List<AvailableDate> findByDoctorId(int doctorId) {
        return this.availableDateRepo.findByDoctorId(doctorId);
    }

    @Override
    public boolean existsByDoctorIdAndAvailableDate(int doctorId, LocalDate availableDate) {
        return this.availableDateRepo.existsByDoctorIdAndAvailableDate(doctorId, availableDate);
    }
}
