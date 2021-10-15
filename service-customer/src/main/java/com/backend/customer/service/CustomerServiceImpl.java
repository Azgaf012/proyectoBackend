package com.backend.customer.service;

import com.backend.customer.dto.CustomerSimpleDto;
import com.backend.customer.entity.Customer;
import com.backend.customer.mapper.CustomerSimpleMapper;
import com.backend.customer.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import java.util.List;

@Service
@Validated
public class CustomerServiceImpl implements ICustomerService {

    @Autowired
    private CustomerRepository customerRepository;



    @Override
    public List<Customer> listAllCustomer() {
        return customerRepository.findAllByStateTrue();
    }

    @Override
    public Customer getCustomer(Long id) {
        return customerRepository.findById(id).orElse(null);
    }

    @Override
    public Customer createCustomer(Customer customer) {
        customer.setState(true);
        return customerRepository.save(customer);
    }

    @Override
    public Customer updateCustomer(Customer customer) {
        Customer customerDB = getCustomer(customer.getId());

        if(null== customerDB) return null;

        customerDB.setName(customer.getName());
        customerDB.setLastName(customer.getLastName());
        customerDB.setAge(customer.getAge());
        customerDB.setNroDocument(customer.getNroDocument());
        customerDB.setDocumentType(customer.getDocumentType());
        customerDB.setCity(customer.getCity());

        return customerRepository.save(customerDB);
    }

    @Override
    public Customer deleteCustomer(Long id) {
        Customer customerDB = getCustomer(id);

        if(null== customerDB) return null;

        customerDB.setState(false);

        return customerRepository.save(customerDB);
    }
}
