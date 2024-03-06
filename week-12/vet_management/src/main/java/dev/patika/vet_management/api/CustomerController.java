package dev.patika.vet_management.api;

import dev.patika.vet_management.bussiness.abstracts.ICustomerService;
import dev.patika.vet_management.core.config.modelMapper.IModelMapperService;
import dev.patika.vet_management.core.result.Result;
import dev.patika.vet_management.core.result.ResultWithData;
import dev.patika.vet_management.core.utilities.ResultHelper;
import dev.patika.vet_management.dto.CursorResponse;
import dev.patika.vet_management.dto.request.customer.CustomerSaveRequest;
import dev.patika.vet_management.dto.request.customer.CustomerUpdateRequest;
import dev.patika.vet_management.dto.response.animal.AnimalResponse;
import dev.patika.vet_management.dto.response.customer.CustomerResponse;
import dev.patika.vet_management.entities.Animal;
import dev.patika.vet_management.entities.Customer;
import jakarta.validation.Valid;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/v1/customers") //endpoint
public class CustomerController {
    private final ICustomerService customerService;
    private final IModelMapperService modelMapper;


    public CustomerController(ICustomerService customerService, IModelMapperService modelMapper) {
        this.customerService = customerService;
        this.modelMapper = modelMapper;
    }

    //CRUD

    //for save
    @PostMapping()
    @ResponseStatus(HttpStatus.CREATED)
    public ResultWithData<CustomerResponse> save(@Valid @RequestBody CustomerSaveRequest customerSaveRequest) {
        Customer customer = this.modelMapper.forRequest().map(customerSaveRequest, Customer.class);
        this.customerService.save(customer);
        return ResultHelper.success(this.modelMapper.forResponse().map(customer, CustomerResponse.class));
    }

    //for get by id
    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ResultWithData<CustomerResponse> get(@PathVariable("id") int id) {
        Customer customer = this.customerService.get(id);
        return ResultHelper.success(this.modelMapper.forResponse().map(customer, CustomerResponse.class));
    }

    //for update
    @PutMapping()
    @ResponseStatus(HttpStatus.OK)
    public ResultWithData<CustomerResponse> update(@Valid @RequestBody CustomerUpdateRequest customerUpdateRequest) {
        Customer customer = this.modelMapper.forRequest().map(customerUpdateRequest, Customer.class);
        this.customerService.update(customer);
        return ResultHelper.success(this.modelMapper.forResponse().map(customer, CustomerResponse.class));
    }

    //for delete by id
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Result delete(@PathVariable("id") int id) {
        this.customerService.delete(id);
        return ResultHelper.ok();
    }

    //pageable response
    @GetMapping()
    @ResponseStatus(HttpStatus.OK)
    public ResultWithData<CursorResponse<CustomerResponse>> cursor(
            @RequestParam(name = "page", required = false, defaultValue = "0") int page,
            @RequestParam(name = "pageSize", required = false, defaultValue = "10") int pageSize
    ) {
        Page<Customer> customerPage = this.customerService.cursor(page, pageSize);
        Page<CustomerResponse> customerResponses = customerPage.map(customer -> this.modelMapper.forResponse().map(customer, CustomerResponse.class));
        return ResultHelper.cursor(customerResponses);
    }

    //find customer by name
    @GetMapping("/find")
    @ResponseStatus(HttpStatus.OK)
    public ResultWithData<CursorResponse<CustomerResponse>> findByName(
            @RequestParam String name,
            @RequestParam(required = false, defaultValue = "0") int page,
            @RequestParam(required = false, defaultValue = "10") int pageSize
    ) {
        Pageable pageable = PageRequest.of(page, pageSize);
        Page<Customer> filteredCustomers = this.customerService.findByName(name, pageable);
        Page<CustomerResponse> animalResponses = filteredCustomers.map(customer -> this.modelMapper.forResponse().map(customer, CustomerResponse.class));
        return ResultHelper.cursor(animalResponses);
    }
}
