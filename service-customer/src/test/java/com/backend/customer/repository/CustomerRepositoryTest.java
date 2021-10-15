package com.backend.customer.repository;

import com.backend.customer.entity.City;
import com.backend.customer.entity.Customer;
import com.backend.customer.entity.DocumentType;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.List;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
class CustomerRepositoryTest {

    @Autowired
    private CustomerRepository customerRepository;

    private Customer customer;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);

        customer = Customer.builder()
                .name("Juan")
                .lastName("Perez Paz")
                .nroDocument("12345678")
                .age(25)
                .documentType(DocumentType.builder().id(1L).build())
                .city(City.builder().id(1L).build())
                .state(true)
                .build();
    }

    @Test
    void findAllByStateIsTrue() {
        customerRepository.save(customer);
        List<Customer> listCustomers = customerRepository.findAllByStateTrue();
        Assertions.assertThat(listCustomers.size()).isGreaterThan(0);
    }


}