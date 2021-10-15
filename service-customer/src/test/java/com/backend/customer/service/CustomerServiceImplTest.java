package com.backend.customer.service;

import com.backend.customer.dto.CustomerSimpleDto;
import com.backend.customer.entity.City;
import com.backend.customer.entity.Customer;
import com.backend.customer.entity.DocumentType;
import com.backend.customer.repository.CustomerRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Arrays;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class CustomerServiceImplTest {

    @Mock
    private CustomerRepository customerRepository;

    @InjectMocks
    private CustomerServiceImpl clientService;

    private Customer customer;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);

        customer = Customer.builder()
                .id(1L)
                .name("Juan")
                .lastName("Perez Paz")
                .nroDocument("12345678")
                .age(25)
                .documentType(DocumentType.builder().id(1L).build())
                .city(City.builder().id(1L).build())
                .state(true)
                .build();

        Mockito.when(customerRepository.findById(1L))
                .thenReturn(Optional.of(customer));

        Mockito.when(customerRepository.save(customer))
                .thenReturn(customer);
    }

    @Test
    void whenValidGetId_ThenReturnClient() {
        Customer found = clientService.getCustomer(1L);
        Assertions.assertThat(found.getName()).isEqualTo("Juan");
    }

    @Test
    void listAllCustomers() {
        Mockito.when(customerRepository.findAllByStateTrue()).thenReturn(Arrays.asList(customer));
        assertNotNull(clientService.listAllCustomer());
    }

    @Test
    void createCustomer() {

        Customer customerDB =clientService.createCustomer(customer);
        Assertions.assertThat(customerDB.getName()).isEqualTo(customer.getName());
    }

    @Test
    void updateCustomer(){
        customer.setName("Pedro");
        Customer customerDB = clientService.updateCustomer(customer);
        Assertions.assertThat(customerDB.getName()).isEqualTo(customer.getName());

    }

    @Test
    void deleteCustomer(){
        Customer customerDB = clientService.deleteCustomer(customer.getId());
        Assertions.assertThat(customerDB.getState()).isEqualTo(false);

    }



}