package dev.patika.vet_management.api;

import dev.patika.vet_management.bussiness.abstracts.IAvailableDateService;
import dev.patika.vet_management.bussiness.abstracts.IDoctorService;
import dev.patika.vet_management.core.config.modelMapper.IModelMapperService;
import dev.patika.vet_management.core.result.Result;
import dev.patika.vet_management.core.result.ResultWithData;
import dev.patika.vet_management.core.utilities.ResultHelper;
import dev.patika.vet_management.dto.CursorResponse;
import dev.patika.vet_management.dto.request.availableDate.AvailableDateSaveRequest;
import dev.patika.vet_management.dto.request.availableDate.AvailableDateUpdateRequest;
import dev.patika.vet_management.dto.response.availableDate.AvailableDateResponse;
import dev.patika.vet_management.entities.AvailableDate;
import dev.patika.vet_management.entities.Doctor;
import jakarta.validation.Valid;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/v1/available-dates") //endpoint
public class AvailableDateController {
    private final IAvailableDateService availableDateService;
    private final IDoctorService doctorService;
    private final IModelMapperService modelMapper;

    public AvailableDateController(IAvailableDateService availableDateService, IDoctorService doctorService, IModelMapperService modelMapper) {
        this.availableDateService = availableDateService;
        this.doctorService = doctorService;
        this.modelMapper = modelMapper;
    }

    //CRUD

    //for save
    @PostMapping()
    @ResponseStatus(HttpStatus.CREATED)
    public ResultWithData<AvailableDateResponse> save(@Valid @RequestBody AvailableDateSaveRequest availableDateSaveRequest) {
        AvailableDate availableDate = this.modelMapper.forRequest().map(availableDateSaveRequest, AvailableDate.class);

        Doctor doctor = this.doctorService.get(availableDateSaveRequest.getDoctorId());
        availableDate.setDoctor(doctor);

        this.availableDateService.save(availableDate);
        return ResultHelper.success(this.modelMapper.forResponse().map(availableDate, AvailableDateResponse.class));
    }

    //for get by id
    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ResultWithData<AvailableDateResponse> get(@PathVariable("id") int id) {
        AvailableDate availableDate = this.availableDateService.get(id);
        return ResultHelper.success(this.modelMapper.forResponse().map(availableDate, AvailableDateResponse.class));
    }

    //for update
    @PutMapping()
    @ResponseStatus(HttpStatus.OK)
    public ResultWithData<AvailableDateResponse> update(@Valid @RequestBody AvailableDateUpdateRequest availableDateUpdateRequest) {
        AvailableDate availableDate = this.modelMapper.forRequest().map(availableDateUpdateRequest, AvailableDate.class);

        Doctor doctor = this.doctorService.get(availableDateUpdateRequest.getDoctorId());
        availableDate.setDoctor(doctor);

        this.availableDateService.update(availableDate);
        return ResultHelper.success(this.modelMapper.forResponse().map(availableDate, AvailableDateResponse.class));
    }

    //for delete by id
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Result delete(@PathVariable("id") int id) {
        this.availableDateService.delete(id);
        return ResultHelper.ok();
    }

    //pageable response
    @GetMapping()
    @ResponseStatus(HttpStatus.OK)
    public ResultWithData<CursorResponse<AvailableDateResponse>> cursor(
            @RequestParam(name = "page", required = false, defaultValue = "0") int page,
            @RequestParam(name = "pageSize", required = false, defaultValue = "10") int pageSize
    ){
        Page<AvailableDate> availableDatePage = this.availableDateService.cursor(page, pageSize);
        Page<AvailableDateResponse> availableDateResponses = availableDatePage.map(
                availableDate -> this.modelMapper.forResponse().map(availableDate, AvailableDateResponse.class)
               );
        return ResultHelper.cursor(availableDateResponses);
    }

}