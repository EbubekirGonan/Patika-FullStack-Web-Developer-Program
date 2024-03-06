package dev.patika.vet_management.dao;

import dev.patika.vet_management.entities.Customer;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepo extends JpaRepository<Customer, Integer> {
    Page<Customer> findByName(String name, Pageable pageable);
    boolean existsByMail(String mail);
}
