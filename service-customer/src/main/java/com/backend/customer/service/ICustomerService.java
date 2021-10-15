package com.backend.customer.service;

import com.backend.customer.dto.CustomerSimpleDto;
import com.backend.customer.entity.Customer;

import java.util.List;

public interface ICustomerService {
    public List<Customer> listAllCustomer();
    public Customer getCustomer(Long id);
    public Customer createCustomer(Customer customer);
    public Customer updateCustomer(Customer customer);
    public Customer deleteCustomer(Long id);
}
