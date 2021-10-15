package com.backend.customer.mapper;

import com.backend.customer.dto.CityDto;
import com.backend.customer.dto.CustomerSimpleDto;
import com.backend.customer.dto.DocumentTypeDto;
import com.backend.customer.entity.City;
import com.backend.customer.entity.Customer;
import com.backend.customer.entity.DocumentType;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class CustomerSimpleMapperTest {

    @Autowired
    private CustomerSimpleMapperImpl customerSimpleMapper;

    private Customer customer;
    private CustomerSimpleDto customerSimpleDto;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);

        customerSimpleDto = CustomerSimpleDto.builder()
                .id(1L)
                .name("Juan")
                .lastName("Perez")
                .age(35)
                .nroDocument("12345678")
                .city(CityDto.builder().id(1L).name("Trujillo").build())
                .documentType(DocumentTypeDto.builder().id(1L).name("DNI").build())
                .build();
    }

    @Test
    void customerDTOToCustomer() {
        CustomerSimpleDto customerSimpleDto = customerSimpleMapper.customerToCustomerSimpleDTO(customer);
        Assertions.assertThat(customerSimpleDto.getId()).isEqualTo(customer.getId());
    }

    @Test
    void customerToCustomerSimpleDTO() {
        Customer customer = customerSimpleMapper.customerDTOToCustomer(customerSimpleDto);
        Assertions.assertThat(customer.getName()).isEqualTo(customerSimpleDto.getName());
    }

    @Test
    void listCustomersToListCustomersSimpleDTOs() {
        List<Customer> customerList = Arrays.asList(customer);
        List<CustomerSimpleDto> customerSimpleDtoList = customerSimpleMapper.listCustomersToListCustomersSimpleDTOs(customerList);
        assertNotNull(customerSimpleDtoList);
    }
}