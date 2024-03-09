package dev.patika.vet_management.api;

import dev.patika.vet_management.bussiness.abstracts.IAnimalService;
import dev.patika.vet_management.bussiness.abstracts.IAppointmentService;
import dev.patika.vet_management.bussiness.abstracts.IDoctorService;
import dev.patika.vet_management.core.config.modelMapper.IModelMapperService;
import dev.patika.vet_management.core.result.Result;
import dev.patika.vet_management.core.result.ResultWithData;
import dev.patika.vet_management.core.utilities.ResultHelper;
import dev.patika.vet_management.dto.CursorResponse;
import dev.patika.vet_management.dto.request.appointment.AppointmentSaveRequest;
import dev.patika.vet_management.dto.request.appointment.AppointmentUpdateRequest;
import dev.patika.vet_management.dto.response.appointment.AppointmentResponse;
import dev.patika.vet_management.entities.Animal;
import dev.patika.vet_management.entities.Appointment;
import dev.patika.vet_management.entities.Doctor;
import jakarta.validation.Valid;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.LocalDateTime;

@RestController
@RequestMapping("/v1/appointments") //endpoint
public class AppointmentController {
    private final IAppointmentService appointmentService;


    public AppointmentController(IAppointmentService appointmentService) {
        this.appointmentService = appointmentService;
    }

    //CRUD

    //for save
    @PostMapping()
    @ResponseStatus(HttpStatus.CREATED)
    public ResultWithData<AppointmentResponse> save(
            @Valid @RequestBody AppointmentSaveRequest appointmentSaveRequest) {
        return ResultHelper.success(this.appointmentService.save(appointmentSaveRequest));
    }

    //for get by id
    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ResultWithData<AppointmentResponse> get(@PathVariable("id") int id) {
        return ResultHelper.success(this.appointmentService.get(id));
    }

    //for update
    @PutMapping()
    @ResponseStatus(HttpStatus.OK)
    public ResultWithData<AppointmentResponse> update(
            @Valid @RequestBody AppointmentUpdateRequest appointmentUpdateRequest) {
        return ResultHelper.success(this.appointmentService.update(appointmentUpdateRequest));
    }

    //for delete by id
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Result delete(@PathVariable("id") int id) {
        this.appointmentService.delete(id);
        return ResultHelper.ok();
    }

    // for pageable response
    @GetMapping()
    @ResponseStatus(HttpStatus.OK)
    public ResultWithData<CursorResponse<AppointmentResponse>> cursor(
            @RequestParam(name = "page", required = false, defaultValue = "0") int page,
            @RequestParam(name = "pageSize", required = false, defaultValue = "10") int pageSize
    ) {
        return ResultHelper.cursor(this.appointmentService.cursor(page, pageSize));
    }

    //for find by animal id and date between
    //start date and end date can be omitted. it's not necessary
    @GetMapping("/findByAnimalId")
    @ResponseStatus(HttpStatus.OK)
    public ResultWithData<CursorResponse<AppointmentResponse>> findByAnimalIdAndAppointmentDateBetween(
            @RequestParam(name = "animalId") int animalId,
            @RequestParam(name = "startDate", required = false, defaultValue = "1970-01-01") LocalDate startDate,
            @RequestParam(name = "endDate", required = false, defaultValue = "2100-01-01") LocalDate endDate,
            @RequestParam(required = false, defaultValue = "0") int page,
            @RequestParam(required = false, defaultValue = "10") int pageSize
    ) {
        Pageable pageable = PageRequest.of(page, pageSize);
        LocalDateTime startDateTime = startDate.atStartOfDay();
        LocalDateTime endDateTime = endDate.atStartOfDay();
        return ResultHelper.cursor(this.appointmentService.findByAnimalIdAndAppointmentDateTimeBetween(animalId, startDateTime, endDateTime, pageable));
    }

    //for find by doctor id and date between
    //start date and end date can be omitted. it's not necessary
    @GetMapping("/findByDoctorId")
    @ResponseStatus(HttpStatus.OK)
    public ResultWithData<CursorResponse<AppointmentResponse>> findByDoctorIdAndAppointmentDateTimeBetween(
            @RequestParam(name = "doctorId") int doctorId,
            @RequestParam(name = "startDate", required = false, defaultValue = "1970-01-01") LocalDate startDate,
            @RequestParam(name = "endDate", required = false, defaultValue = "2100-01-01") LocalDate endDate,
            @RequestParam(required = false, defaultValue = "0") int page,
            @RequestParam(required = false, defaultValue = "10") int pageSize
    ) {
        Pageable pageable = PageRequest.of(page, pageSize);
        LocalDateTime startDateTime = startDate.atStartOfDay();
        LocalDateTime endDateTime = endDate.atStartOfDay();
        return ResultHelper.cursor(this.appointmentService.findByDoctorIdAndAppointmentDateTimeBetween(doctorId, startDateTime, endDateTime, pageable));
    }
}
