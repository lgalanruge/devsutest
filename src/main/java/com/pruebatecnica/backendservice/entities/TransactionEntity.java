package com.pruebatecnica.backendservice.entities;

import com.pruebatecnica.backendservice.utils.TransactionType;
import jakarta.persistence.*;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Date;

@Data
@Entity
@Table(name = "transactions")
public class TransactionEntity {

    @Id
    private String id ;

    @Column(name = "transaction_date")
    private LocalDate date ;

    @Column(name = "transaction_type")
    private TransactionType type ;

    @Column(name = "transaction_value")
    private BigDecimal value ;

    @Column(name = "transaction_amount")
    private BigDecimal amount ;



    @ManyToOne
    @JoinColumn(name = "account_id", referencedColumnName = "id")
    private AccountEntity accountId ;





}
