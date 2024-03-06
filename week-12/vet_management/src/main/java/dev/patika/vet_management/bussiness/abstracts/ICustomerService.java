package dev.patika.vet_management.bussiness.abstracts;

import dev.patika.vet_management.entities.Customer;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface ICustomerService {
    Customer save(Customer customer);
    Customer update(Customer customer);
    Customer get(int id);
    boolean delete(int id);
    Page<Customer> cursor(int page, int pageSize);
    Page<Customer> findByName(String name, Pageable pageable);
    boolean existsByMail(String mail);


}
