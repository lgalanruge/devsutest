package com.pruebatecnica.backendservice.entities;

import com.pruebatecnica.backendservice.utils.Status;
import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "customer")
public class CustomerEntity  {

    @Id
    private String customerId ;

    @Column(name = "password", nullable = false)
    private  String passWord ;

    @Column(name = "status")
    private Status status ;


    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "person_id", referencedColumnName = "id")
    private PersonEntity personId ;



}
