package com.backend.customer.mapper;

import com.backend.customer.dto.CityDto;
import com.backend.customer.dto.CustomerSimpleDto;
import com.backend.customer.dto.DocumentTypeDto;
import com.backend.customer.entity.City;
import com.backend.customer.entity.Customer;
import com.backend.customer.entity.DocumentType;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import java.util.List;

@Mapper(componentModel = "spring")
public interface CustomerSimpleMapper {
    @Mappings({
            @Mapping(target = "createAT", ignore = true),
            @Mapping(target = "updateAT", ignore = true),
            @Mapping(target = "state", ignore = true)
    })
    Customer customerDTOToCustomer(CustomerSimpleDto customerSimpleDto);

    CustomerSimpleDto customerToCustomerSimpleDTO(Customer customer);

    City cityDTOToCity(CityDto cityDto);
    CityDto cityToCityDTO(City city);

    DocumentType documentTypeDTOToCity(DocumentTypeDto documentTypeDto);
    DocumentTypeDto documentTypeToDocumentTypeDTO(DocumentType documentType);

    List<CustomerSimpleDto> listCustomersToListCustomersSimpleDTOs(List<Customer> listCustomer);
}
