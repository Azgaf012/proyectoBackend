package com.backend.customer.entity;

import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "ciudad")
@Getter @Setter
@Builder @NoArgsConstructor @AllArgsConstructor
public class City {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idCiudad")
    private Long id;

    @Column(name="nombre")
    private String name;
}
