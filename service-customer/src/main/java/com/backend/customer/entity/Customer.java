package com.backend.customer.entity;

import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import java.util.Date;

@Entity
@Table(name="Cliente")
@AllArgsConstructor @NoArgsConstructor @Builder
@Getter @Setter
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idCliente")
    private Long id;

    @NotEmpty(message="Debe ingresar un nombre")
    @Column(name = "nombres")
    private String name;

    @NotEmpty(message="Debe ingresar el apellido")
    @Column(name = "apellidos")
    private String lastName;

    @Positive(message = "Debe ingresar una edad valida")
    @Column(name = "edad")
    private int age;

    @Column(name = "nroDocumento")
    private String nroDocument;

    @Column(name = "estado")
    private Boolean state;

    @NotNull(message = "Ingrese una ciudad valida")
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "idCiudad")
    private City city;

    @NotNull(message = "Ingrese un documento valido")
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "idTipoDocumento")
    private DocumentType documentType;

    @CreationTimestamp
    @Temporal(TemporalType.TIMESTAMP)
    private Date createAT;

    @UpdateTimestamp
    @Temporal(TemporalType.TIMESTAMP)
    private Date updateAT;

}
