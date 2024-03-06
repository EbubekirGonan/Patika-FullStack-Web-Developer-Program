package dev.patika.vet_management.bussiness.concretes;

import dev.patika.vet_management.bussiness.abstracts.IDoctorService;
import dev.patika.vet_management.core.exception.NotFoundException;
import dev.patika.vet_management.core.utilities.Msg;
import dev.patika.vet_management.dao.DoctorRepo;
import dev.patika.vet_management.entities.Doctor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class DoctorManager implements IDoctorService {
    private final DoctorRepo doctorRepo;

    public DoctorManager(DoctorRepo doctorRepo) {
        this.doctorRepo = doctorRepo;
    }

    @Override
    public Doctor save(Doctor doctor) {
        if(this.existsByMail(doctor.getMail())){
            throw new RuntimeException("Bu mail adresiyle daha önce kayıt yapılmıştır. Lütfen başka bir mail adresi ile deneyin");
        }else {
            return this.doctorRepo.save(doctor);
        }
    }

    @Override
    public Doctor update(Doctor doctor) {
        if(!(this.doctorRepo.findById(doctor.getId()).get().getMail().equals(doctor.getMail()))
                && this.existsByMail(doctor.getMail())){
            throw new RuntimeException("Bu mail adresiyle daha önce kayıt yapılmıştır. Lütfen başka bir mail adresi ile deneyin");
        } else {
            return this.doctorRepo.save(doctor);
        }
    }

    @Override
    public Doctor get(int id) {
        return this.doctorRepo.findById(id).orElseThrow(() -> new NotFoundException(Msg.NOT_FOUND));
    }

    @Override
    public boolean delete(int id) {
        this.doctorRepo.delete(this.get(id));
        return true;
    }

    @Override
    public Page<Doctor> cursor(int page, int pageSize) {
        Pageable pageable = PageRequest.of(page, pageSize);
        return this.doctorRepo.findAll(pageable);
    }

    @Override
    public boolean existsByMail(String mail) {
        return this.doctorRepo.existsByMail(mail);
    }
}
