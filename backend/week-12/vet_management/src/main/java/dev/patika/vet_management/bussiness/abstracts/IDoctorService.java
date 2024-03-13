package dev.patika.vet_management.bussiness.abstracts;

import dev.patika.vet_management.dto.request.doctor.DoctorSaveRequest;
import dev.patika.vet_management.dto.request.doctor.DoctorUpdateRequest;
import dev.patika.vet_management.dto.response.doctor.DoctorResponse;
import dev.patika.vet_management.entities.Doctor;
import org.springframework.data.domain.Page;

public interface IDoctorService {
    DoctorResponse save(DoctorSaveRequest doctorSaveRequest);
    DoctorResponse update(DoctorUpdateRequest doctorUpdateRequest);
    DoctorResponse get(int id);
    boolean delete(int id);
    Page<DoctorResponse> cursor(int page, int pageSize);
    boolean existsByMail(String mail);

}
