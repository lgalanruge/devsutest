package com.pruebatecnica.backendservice.entities;

import com.pruebatecnica.backendservice.utils.AccountType;
import com.pruebatecnica.backendservice.utils.Status;
import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;


import java.math.BigDecimal;
import java.util.List;



@Getter
@Setter
@Entity
@Table(name = "account")
public class AccountEntity {

    @Id
    private String id ;

    @Column(name = "account_number", nullable = false)
    private  Long accountNumber ;

    @Column(name = "amount")
    private BigDecimal amount ;

    @Column(name = "status")
    private Status status ;

    @Column(name = "type")
    private AccountType type ;


    @ManyToOne
    @JoinColumn(name = "entity_id", referencedColumnName = "id")
    private EntityEntity entityId ;


    @OneToMany(mappedBy = "accountId")
    private List<TransactionEntity> transactions ;

    @ManyToOne
    @JoinColumn(name = "customer_id", referencedColumnName = "customerId")
    private CustomerEntity customerId ;

    @Override
    public String toString() {
        return "AccountEntity{" +
                "id='" + id + '\'' +
                ", accountNumber=" + accountNumber +
                ", status=" + status +
                ", customerId=" + customerId +
                '}';
    }
}
