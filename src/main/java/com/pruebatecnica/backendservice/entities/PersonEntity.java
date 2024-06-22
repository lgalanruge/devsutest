package com.pruebatecnica.backendservice.entities;

import com.pruebatecnica.backendservice.utils.Genere;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "person")
public class PersonEntity {

    @Id
    private String id ;

    @Column(name = "name", nullable = false)
    private String name ;

    @Column(name = "age")
    private  Integer age ;

    @Column(name = "person_id", nullable = false)
    private Long identificationNumber ;

    @Column(name = "address")
    private String address ;

    @Column(name = "phone")
    private String phoneNumber ;

    @Column(name = "genere")
    private Genere genere ;




}
