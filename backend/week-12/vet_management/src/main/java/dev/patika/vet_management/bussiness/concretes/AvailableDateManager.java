package dev.patika.vet_management.bussiness.concretes;

import dev.patika.vet_management.bussiness.abstracts.IAvailableDateService;
import dev.patika.vet_management.core.config.modelMapper.IModelMapperService;
import dev.patika.vet_management.core.exception.NotFoundException;
import dev.patika.vet_management.core.utilities.Msg;
import dev.patika.vet_management.dao.AvailableDateRepo;
import dev.patika.vet_management.dao.DoctorRepo;
import dev.patika.vet_management.dto.request.availableDate.AvailableDateSaveRequest;
import dev.patika.vet_management.dto.request.availableDate.AvailableDateUpdateRequest;
import dev.patika.vet_management.dto.response.availableDate.AvailableDateResponse;
import dev.patika.vet_management.entities.AvailableDate;
import dev.patika.vet_management.entities.Doctor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
public class AvailableDateManager implements IAvailableDateService {
    private final AvailableDateRepo availableDateRepo;
    private final DoctorRepo doctorRepo;
    private final IModelMapperService modelMapper;

    public AvailableDateManager(AvailableDateRepo availableDateRepo, DoctorRepo doctorRepo, IModelMapperService modelMapper) {
        this.availableDateRepo = availableDateRepo;
        this.doctorRepo = doctorRepo;
        this.modelMapper = modelMapper;
    }

    @Override
    public AvailableDateResponse save(AvailableDateSaveRequest availableDateSaveRequest) {
        AvailableDate availableDate = this.modelMapper.forRequest().map(availableDateSaveRequest, AvailableDate.class);

        if (this.existsByDoctorIdAndAvailableDate(availableDateSaveRequest.getDoctorId(), availableDateSaveRequest.getAvailableDate())) {
            throw new RuntimeException("Belirtilen doktorun takvimine belirtilen gün daha önce eklenmiştir. Lütfen başka bir gün seçiniz.");
        } else {

            Doctor doctor = this.doctorRepo.findById(availableDateSaveRequest.getDoctorId()).get();
            availableDate.setDoctor(doctor);

            return this.modelMapper.forResponse().map(this.availableDateRepo.save(availableDate), AvailableDateResponse.class);
        }
    }


    @Override
    public AvailableDateResponse update(AvailableDateUpdateRequest availableDateUpdateRequest) {


        if (this.existsByDoctorIdAndAvailableDate(availableDateUpdateRequest.getDoctorId(), availableDateUpdateRequest.getAvailableDate())) {
            throw new RuntimeException("Belirtilen doktorun takvimine belirtilen gün daha önce eklenmiştir. Lütfen başka bir gün seçiniz.");
        } else {
            AvailableDate availableDate = this.modelMapper.forRequest().map(availableDateUpdateRequest, AvailableDate.class);

            Doctor doctor = this.doctorRepo.findById(availableDateUpdateRequest.getDoctorId()).get();
            availableDate.setDoctor(doctor);

            System.out.println(availableDate.getId());
            return this.modelMapper.forResponse().map(this.availableDateRepo.save(availableDate), AvailableDateResponse.class);
        }
    }


    @Override
    public AvailableDateResponse get(int id) {
        AvailableDate availableDate = this.availableDateRepo.findById(id).orElseThrow(() -> new NotFoundException(Msg.NOT_FOUND));
        return this.modelMapper.forResponse().map(availableDate, AvailableDateResponse.class);
    }

    @Override
    public boolean delete(int id) {
        this.availableDateRepo.delete(this.availableDateRepo.findById(id).get());
        return true;
    }

    @Override
    public Page<AvailableDateResponse> cursor(int page, int pageSize) {
        Pageable pageable = PageRequest.of(page, pageSize);
        Page<AvailableDate> availableDatePage = this.availableDateRepo.findAll(pageable);
        return availableDatePage.map(availableDate -> this.modelMapper.forResponse().map(availableDate, AvailableDateResponse.class));
    }


    @Override
    public boolean existsByDoctorIdAndAvailableDate(int doctorId, LocalDate availableDate) {
        return this.availableDateRepo.existsByDoctorIdAndAvailableDate(doctorId, availableDate);
    }
}
