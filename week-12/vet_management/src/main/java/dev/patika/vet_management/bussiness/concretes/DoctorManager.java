package dev.patika.vet_management.bussiness.concretes;

import dev.patika.vet_management.bussiness.abstracts.IDoctorService;
import dev.patika.vet_management.core.config.modelMapper.IModelMapperService;
import dev.patika.vet_management.core.exception.NotFoundException;
import dev.patika.vet_management.core.utilities.Msg;
import dev.patika.vet_management.dao.DoctorRepo;
import dev.patika.vet_management.dto.request.doctor.DoctorSaveRequest;
import dev.patika.vet_management.dto.request.doctor.DoctorUpdateRequest;
import dev.patika.vet_management.dto.response.doctor.DoctorResponse;
import dev.patika.vet_management.entities.Doctor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class DoctorManager implements IDoctorService {
    private final DoctorRepo doctorRepo;
    private final IModelMapperService modelMapper;

    public DoctorManager(DoctorRepo doctorRepo, IModelMapperService modelMapper) {
        this.doctorRepo = doctorRepo;
        this.modelMapper = modelMapper;
    }

    @Override
    public DoctorResponse save(DoctorSaveRequest doctorSaveRequest) {
        Doctor doctor = this.modelMapper.forRequest().map(doctorSaveRequest, Doctor.class);

        if(this.existsByMail(doctorSaveRequest.getMail())){
            throw new RuntimeException("Bu mail adresiyle daha önce kayıt yapılmıştır. Lütfen başka bir mail adresi ile deneyin");
        }else {
            return this.modelMapper.forResponse().map(this.doctorRepo.save(doctor), DoctorResponse.class);
        }
    }

    @Override
    public DoctorResponse update(DoctorUpdateRequest doctorUpdateRequest) {
        Doctor doctor = this.modelMapper.forRequest().map(doctorUpdateRequest, Doctor.class);

        if(!(this.doctorRepo.findById(doctorUpdateRequest.getId()).get().getMail().equals(doctorUpdateRequest.getMail()))
                && this.existsByMail(doctorUpdateRequest.getMail())){
            throw new RuntimeException("Bu mail adresiyle daha önce kayıt yapılmıştır. Lütfen başka bir mail adresi ile deneyin");
        } else {

            return this.modelMapper.forResponse().map(this.doctorRepo.save(doctor), DoctorResponse.class);
        }
    }

    @Override
    public DoctorResponse get(int id) {
        Doctor doctor = this.doctorRepo.findById(id).orElseThrow(() -> new NotFoundException(Msg.NOT_FOUND));
        return this.modelMapper.forResponse().map(doctor, DoctorResponse.class);
    }

    @Override
    public boolean delete(int id) {
        this.doctorRepo.delete(this.doctorRepo.findById(id).get());
        return true;
    }

    @Override
    public Page<DoctorResponse> cursor(int page, int pageSize) {
        Pageable pageable = PageRequest.of(page, pageSize);
        Page<Doctor> doctorPage = this.doctorRepo.findAll(pageable);
        return doctorPage.map(doctor -> this.modelMapper.forResponse().map(doctor, DoctorResponse.class));
    }

    @Override
    public boolean existsByMail(String mail) {
        return this.doctorRepo.existsByMail(mail);
    }
}
