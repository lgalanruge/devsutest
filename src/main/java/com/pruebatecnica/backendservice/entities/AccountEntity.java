package com.pruebatecnica.backendservice.entities;

import com.pruebatecnica.backendservice.utils.AccountType;
import com.pruebatecnica.backendservice.utils.Status;
import jakarta.persistence.*;
import lombok.Data;

<<<<<<< HEAD
import java.util.List;
=======
>>>>>>> 0b2c909d87938cf082da51547a4e358275d7ae49


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

<<<<<<< HEAD
    @OneToMany(mappedBy = "accountId")
    private List<TransactionEntity> transactions ;

    @ManyToOne
    @JoinColumn(name = "customer_id", referencedColumnName = "customerId")
    private CustomerEntity customerId ;

=======
>>>>>>> 0b2c909d87938cf082da51547a4e358275d7ae49
}
