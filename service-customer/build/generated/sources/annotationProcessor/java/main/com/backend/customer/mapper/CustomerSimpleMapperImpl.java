package com.backend.customer.mapper;

import com.backend.customer.dto.CityDto;
import com.backend.customer.dto.CustomerSimpleDto;
import com.backend.customer.dto.DocumentTypeDto;
import com.backend.customer.entity.City;
import com.backend.customer.entity.Customer;
import com.backend.customer.entity.DocumentType;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2021-10-14T16:36:35-0500",
    comments = "version: 1.5.0.Beta1, compiler: IncrementalProcessingEnvironment from gradle-language-java-7.2.jar, environment: Java 11.0.12 (Oracle Corporation)"
)
@Component
public class CustomerSimpleMapperImpl implements CustomerSimpleMapper {

    @Override
    public Customer customerDTOToCustomer(CustomerSimpleDto customerSimpleDto) {
        if ( customerSimpleDto == null ) {
            return null;
        }

        Customer customer = new Customer();

        customer.setId( customerSimpleDto.getId() );
        customer.setName( customerSimpleDto.getName() );
        customer.setLastName( customerSimpleDto.getLastName() );
        customer.setAge( customerSimpleDto.getAge() );
        customer.setNroDocument( customerSimpleDto.getNroDocument() );
        customer.setCity( cityDTOToCity( customerSimpleDto.getCity() ) );
        customer.setDocumentType( documentTypeDTOToCity( customerSimpleDto.getDocumentType() ) );

        return customer;
    }

    @Override
    public CustomerSimpleDto customerToCustomerSimpleDTO(Customer customer) {
        if ( customer == null ) {
            return null;
        }

        CustomerSimpleDto customerSimpleDto = new CustomerSimpleDto();

        customerSimpleDto.setId( customer.getId() );
        customerSimpleDto.setName( customer.getName() );
        customerSimpleDto.setLastName( customer.getLastName() );
        customerSimpleDto.setAge( customer.getAge() );
        customerSimpleDto.setDocumentType( documentTypeToDocumentTypeDTO( customer.getDocumentType() ) );
        customerSimpleDto.setNroDocument( customer.getNroDocument() );
        customerSimpleDto.setCity( cityToCityDTO( customer.getCity() ) );

        return customerSimpleDto;
    }

    @Override
    public City cityDTOToCity(CityDto cityDto) {
        if ( cityDto == null ) {
            return null;
        }

        City city = new City();

        city.setId( cityDto.getId() );
        city.setName( cityDto.getName() );

        return city;
    }

    @Override
    public CityDto cityToCityDTO(City city) {
        if ( city == null ) {
            return null;
        }

        CityDto cityDto = new CityDto();

        cityDto.setId( city.getId() );
        cityDto.setName( city.getName() );

        return cityDto;
    }

    @Override
    public DocumentType documentTypeDTOToCity(DocumentTypeDto documentTypeDto) {
        if ( documentTypeDto == null ) {
            return null;
        }

        DocumentType documentType = new DocumentType();

        documentType.setId( documentTypeDto.getId() );
        documentType.setName( documentTypeDto.getName() );

        return documentType;
    }

    @Override
    public DocumentTypeDto documentTypeToDocumentTypeDTO(DocumentType documentType) {
        if ( documentType == null ) {
            return null;
        }

        DocumentTypeDto documentTypeDto = new DocumentTypeDto();

        documentTypeDto.setId( documentType.getId() );
        documentTypeDto.setName( documentType.getName() );

        return documentTypeDto;
    }

    @Override
    public List<CustomerSimpleDto> listCustomersToListCustomersSimpleDTOs(List<Customer> listCustomer) {
        if ( listCustomer == null ) {
            return null;
        }

        List<CustomerSimpleDto> list = new ArrayList<CustomerSimpleDto>( listCustomer.size() );
        for ( Customer customer : listCustomer ) {
            list.add( customerToCustomerSimpleDTO( customer ) );
        }

        return list;
    }
}
