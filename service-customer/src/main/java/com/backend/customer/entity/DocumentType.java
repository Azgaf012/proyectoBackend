package com.backend.customer.entity;

import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "TipoDocumento")
@Getter @Setter
@AllArgsConstructor @NoArgsConstructor @Builder
public class DocumentType {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idTipoDocumento")
    private Long id;

    @Column(name="nombre")
    private String name;
}
