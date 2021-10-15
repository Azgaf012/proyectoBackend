package com.backend.customer.dto;

import com.backend.customer.entity.City;
import com.backend.customer.entity.DocumentType;
import lombok.*;

import javax.validation.constraints.NotEmpty;

@Getter @Setter
@Builder @AllArgsConstructor @NoArgsConstructor
public class CustomerSimpleDto {
    private Long id;
    private String name;
    private String lastName;
    private int age;
    private DocumentTypeDto documentType;
    private String nroDocument;
    private CityDto city;

}
