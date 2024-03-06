package dev.patika.vet_management.bussiness.abstracts;

import dev.patika.vet_management.entities.Doctor;
import org.springframework.data.domain.Page;

public interface IDoctorService {
    Doctor save(Doctor doctor);
    Doctor update(Doctor doctor);
    Doctor get(int id);
    boolean delete(int id);
    Page<Doctor> cursor(int page, int pageSize);
    boolean existsByMail(String mail);

}
