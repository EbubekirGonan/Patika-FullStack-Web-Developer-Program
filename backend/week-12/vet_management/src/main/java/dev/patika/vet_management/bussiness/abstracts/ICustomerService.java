package dev.patika.vet_management.bussiness.abstracts;

import dev.patika.vet_management.dto.request.customer.CustomerSaveRequest;
import dev.patika.vet_management.dto.request.customer.CustomerUpdateRequest;
import dev.patika.vet_management.dto.response.customer.CustomerResponse;
import dev.patika.vet_management.entities.Customer;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface ICustomerService {
    CustomerResponse save(CustomerSaveRequest customerSaveRequest);
    CustomerResponse update(CustomerUpdateRequest customerUpdateRequest);
    CustomerResponse get(int id);
    boolean delete(int id);
    Page<CustomerResponse> cursor(int page, int pageSize);
    Page<CustomerResponse> findByName(String name, Pageable pageable);
    boolean existsByMail(String mail);


}
