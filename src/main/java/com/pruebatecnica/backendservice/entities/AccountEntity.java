package com.pruebatecnica.backendservice.entities;

import com.pruebatecnica.backendservice.utils.AccountType;
import com.pruebatecnica.backendservice.utils.Status;
import jakarta.persistence.*;
import lombok.Data;



@Data
@Entity
@Table(name = "account")
public class AccountEntity {

    @Id
    private String id ;

    @Column(name = "account_number", nullable = false)
    private  Long accountNumber ;

    @Column(name = "amount")
    private Double amount ;

    @Column(name = "status")
    private Status status ;

    @Column(name = "type")
    private AccountType type ;


    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "entity_id", referencedColumnName = "id")
    private EntityEntity entityId ;

}