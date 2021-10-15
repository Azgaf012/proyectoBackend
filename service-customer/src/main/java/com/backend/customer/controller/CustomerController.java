package com.backend.customer.controller;

import com.backend.customer.dto.CustomerSimpleDto;
import com.backend.customer.entity.Customer;
import com.backend.customer.mapper.CustomerSimpleMapper;
import com.backend.customer.service.CustomerServiceImpl;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@RestController
@RequestMapping(value="/customers")
public class CustomerController {

    @Autowired
    private CustomerServiceImpl customerService;

    @Autowired
    private CustomerSimpleMapper customerSimpleMapper;

    @GetMapping
    public ResponseEntity<List<CustomerSimpleDto>> listCustomers(){

        List<CustomerSimpleDto> customerList = customerSimpleMapper.listCustomersToListCustomersSimpleDTOs(customerService.listAllCustomer());

        if(customerList.isEmpty()) return ResponseEntity.noContent().build();

        return ResponseEntity.ok(customerList);
    }

    @GetMapping(value="{id}")
    public ResponseEntity<CustomerSimpleDto> getCustomer(@PathVariable("id") Long id){

        CustomerSimpleDto customer = customerSimpleMapper.customerToCustomerSimpleDTO(customerService.getCustomer(id));

        if(customer==null) return ResponseEntity.noContent().build();

        return ResponseEntity.ok(customer);
    }

    @PostMapping
    public ResponseEntity<CustomerSimpleDto> createCustomer(@RequestBody CustomerSimpleDto customerSimpleDto){
        Customer customer = customerSimpleMapper.customerDTOToCustomer(customerSimpleDto);
        CustomerSimpleDto customerCreate = customerSimpleMapper.customerToCustomerSimpleDTO(customerService.createCustomer(customer));
        return ResponseEntity.status(HttpStatus.CREATED).body(customerCreate);
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<CustomerSimpleDto> updateCustomer(@PathVariable("id") Long id,@RequestBody CustomerSimpleDto customerSimpleDto){
        customerSimpleDto.setId(id);

        Customer customer=customerSimpleMapper.customerDTOToCustomer(customerSimpleDto);

        CustomerSimpleDto customerUpdate = customerSimpleMapper.customerToCustomerSimpleDTO(customerService.updateCustomer(customer));

        if(customerUpdate == null) return ResponseEntity.notFound().build();

        return ResponseEntity.ok(customerUpdate);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<CustomerSimpleDto> deleteCustomer(@PathVariable("id") Long id){

        CustomerSimpleDto customerDelete = customerSimpleMapper.customerToCustomerSimpleDTO(customerService.deleteCustomer(id));

        if(customerDelete == null) return ResponseEntity.notFound().build();

        return ResponseEntity.ok(customerDelete);
    }

    private String formatMessage(BindingResult result){
        List<Map<String,String>> errors=result.getFieldErrors().stream()
                .map(err -> {
                    Map<String,String> error = new HashMap<>();
                    error.put(err.getField(),err.getDefaultMessage());
                    return  error;
                }).collect(Collectors.toList());

        ErrorMessage errorMessage=ErrorMessage.builder()
                .code("01")
                .messages(errors)
                .build();

        ObjectMapper mapper = new ObjectMapper();
        String jsonString="";
        try {
            jsonString=mapper.writeValueAsString(errorMessage);
        }catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return jsonString;
    }
}
