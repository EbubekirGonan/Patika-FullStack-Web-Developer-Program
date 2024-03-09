package dev.patika.vet_management.bussiness.concretes;

import dev.patika.vet_management.bussiness.abstracts.ICustomerService;
import dev.patika.vet_management.core.config.modelMapper.IModelMapperService;
import dev.patika.vet_management.core.exception.NotFoundException;
import dev.patika.vet_management.core.utilities.Msg;
import dev.patika.vet_management.dao.CustomerRepo;
import dev.patika.vet_management.dto.request.customer.CustomerSaveRequest;
import dev.patika.vet_management.dto.request.customer.CustomerUpdateRequest;
import dev.patika.vet_management.dto.response.customer.CustomerResponse;
import dev.patika.vet_management.entities.Customer;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class CustomerManager implements ICustomerService {
    private final CustomerRepo customerRepo;
    private final IModelMapperService modelMapper;

    public CustomerManager(CustomerRepo customerRepo, IModelMapperService modelMapper) {
        this.customerRepo = customerRepo;
        this.modelMapper = modelMapper;
    }

    @Override
    public CustomerResponse save(CustomerSaveRequest customerSaveRequest) {
        Customer customer = this.modelMapper.forRequest().map(customerSaveRequest, Customer.class);

        if (this.existsByMail(customerSaveRequest.getMail())) {
            throw new RuntimeException("Bu mail adresiyle daha önce kayıt yapılmıştır. Lütfen başka bir mail adresi deneyin.");
        } else {
            return this.modelMapper.forResponse().map(this.customerRepo.save(customer), CustomerResponse.class);
        }
    }

    @Override
    public CustomerResponse update(CustomerUpdateRequest customerUpdateRequest) {
        Customer customer = this.modelMapper.forRequest().map(customerUpdateRequest, Customer.class);

        if (!(this.customerRepo.findById(customerUpdateRequest.getId()).get().getMail().equals(customerUpdateRequest.getMail())) &&
                this.existsByMail(customerUpdateRequest.getMail())) {
            throw new RuntimeException("Bu mail adresiyle daha önce kayıt yapılmıştır. Lütfen başka bir mail adresi deneyin.");
        } else {
            return this.modelMapper.forResponse().map(this.customerRepo.save(customer), CustomerResponse.class);
        }
    }

    @Override
    public CustomerResponse get(int id) {
        Customer customer = this.customerRepo.findById(id).orElseThrow(() -> new NotFoundException(Msg.NOT_FOUND));
        return this.modelMapper.forResponse().map(customer, CustomerResponse.class);
    }

    @Override
    public boolean delete(int id) {
        this.customerRepo.delete(this.customerRepo.findById(id).get());
        return true;
    }

    @Override
    public Page<CustomerResponse> cursor(int page, int pageSize) {
        Pageable pageable = PageRequest.of(page, pageSize);
        Page<Customer> customerPage = this.customerRepo.findAll(pageable);
        return customerPage.map(customer -> this.modelMapper.forResponse().map(customer, CustomerResponse.class));
    }

    @Override
    public Page<CustomerResponse> findByName(String name, Pageable pageable) {
        Page<Customer> customerPage = this.customerRepo.findByName(name, pageable);
        return customerPage.map(customer -> this.modelMapper.forResponse().map(customer, CustomerResponse.class));
    }

    @Override
    public boolean existsByMail(String mail) {
        return this.customerRepo.existsByMail(mail);
    }
}
