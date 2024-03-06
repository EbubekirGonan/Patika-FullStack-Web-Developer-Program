package dev.patika.vet_management.api;

import dev.patika.vet_management.bussiness.abstracts.IDoctorService;
import dev.patika.vet_management.core.config.modelMapper.IModelMapperService;
import dev.patika.vet_management.core.result.Result;
import dev.patika.vet_management.core.result.ResultWithData;
import dev.patika.vet_management.core.utilities.ResultHelper;
import dev.patika.vet_management.dto.CursorResponse;
import dev.patika.vet_management.dto.request.doctor.DoctorSaveRequest;
import dev.patika.vet_management.dto.request.doctor.DoctorUpdateRequest;
import dev.patika.vet_management.dto.response.doctor.DoctorResponse;
import dev.patika.vet_management.entities.Doctor;
import jakarta.validation.Valid;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/v1/doctors") //endpoint
public class DoctorController {
    private final IDoctorService doctorService;
    private final IModelMapperService modelMapper;

    public DoctorController(IDoctorService doctorService, IModelMapperService modelMapper) {
        this.doctorService = doctorService;
        this.modelMapper = modelMapper;
    }

    //CRUD

    //for save
    @PostMapping()
    @ResponseStatus(HttpStatus.CREATED)
    public ResultWithData<DoctorResponse> save(@Valid @RequestBody DoctorSaveRequest doctorSaveRequest) {
        Doctor doctor = this.modelMapper.forRequest().map(doctorSaveRequest, Doctor.class);
        this.doctorService.save(doctor);
        return ResultHelper.success(this.modelMapper.forResponse().map(doctor, DoctorResponse.class));
    }

    //for get by id
    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ResultWithData<DoctorResponse> get(@PathVariable("id") int id){
        Doctor doctor = this.doctorService.get(id);
        return ResultHelper.success(this.modelMapper.forResponse().map(doctor, DoctorResponse.class));
    }

    //for update
    @PutMapping()
    @ResponseStatus(HttpStatus.OK)
    public ResultWithData<DoctorResponse> update(@Valid @RequestBody DoctorUpdateRequest doctorUpdateRequest){
        Doctor doctor = this.modelMapper.forRequest().map(doctorUpdateRequest, Doctor.class);
        this.doctorService.update(doctor);
        return ResultHelper.success(this.modelMapper.forResponse().map(doctor, DoctorResponse.class));
    }

    //for delete by id
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Result delete(@PathVariable ("id") int id){
        this.doctorService.delete(id);
        return ResultHelper.ok();
    }

    //pageable response
    @GetMapping()
    @ResponseStatus(HttpStatus.OK)
    public ResultWithData<CursorResponse<DoctorResponse>> cursor(
            @RequestParam(name = "page", required = false, defaultValue = "0")int page,
            @RequestParam(name = "pageSize", required = false, defaultValue = "10")int pageSize
    ){
        Page<Doctor> doctorPage = this.doctorService.cursor(page, pageSize);
        Page<DoctorResponse> doctorResponses = doctorPage.map(doctor -> this.modelMapper.forResponse().map(doctor, DoctorResponse.class));
        return ResultHelper.cursor(doctorResponses);
    }
}
