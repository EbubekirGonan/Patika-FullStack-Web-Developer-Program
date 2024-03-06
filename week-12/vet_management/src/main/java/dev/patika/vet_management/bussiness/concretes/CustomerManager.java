package dev.patika.vet_management.bussiness.concretes;

import dev.patika.vet_management.bussiness.abstracts.ICustomerService;
import dev.patika.vet_management.core.exception.NotFoundException;
import dev.patika.vet_management.core.utilities.Msg;
import dev.patika.vet_management.dao.CustomerRepo;
import dev.patika.vet_management.entities.Customer;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class CustomerManager implements ICustomerService {
    private final CustomerRepo customerRepo;

    public CustomerManager(CustomerRepo customerRepo) {
        this.customerRepo = customerRepo;
    }

    @Override
    public Customer save(Customer customer) {
        if(this.existsByMail(customer.getMail())){
            throw new RuntimeException("Bu mail adresiyle daha önce kayıt yapılmıştır. Lütfen başka bir mail adresi deneyin.");
        }
        else {
            return this.customerRepo.save(customer);
        }
    }

    @Override
    public Customer update(Customer customer) {
        if(!(this.customerRepo.findById(customer.getId()).get().getMail().equals(customer.getMail()))){
            if(this.existsByMail(customer.getMail())){
                throw new RuntimeException("Bu mail adresiyle daha önce kayıt yapılmıştır. Lütfen başka bir mail adresi deneyin.");
            } else{
                return this.customerRepo.save(customer);
            }
        }
        else {
            return this.customerRepo.save(customer);
        }
    }

    @Override
    public Customer get(int id) {
        return this.customerRepo.findById(id).orElseThrow(() -> new NotFoundException(Msg.NOT_FOUND));
    }

    @Override
    public boolean delete(int id) {
        this.customerRepo.delete(this.get(id));
        return true;
    }

    @Override
    public Page<Customer> cursor(int page, int pageSize) {
        Pageable pageable = PageRequest.of(page, pageSize);
        return this.customerRepo.findAll(pageable);
    }

    @Override
    public Page<Customer> findByName(String name, Pageable pageable) {
        return this.customerRepo.findByName(name, pageable);
    }

    @Override
    public boolean existsByMail(String mail) {
        return this.customerRepo.existsByMail(mail);
    }
}
