package com.pruebatecnica.backendservice.dtos;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.pruebatecnica.backendservice.utils.TransactionType;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Date;

@Data
public class Transaction {

    private String id ;

    private LocalDate date ;

    private TransactionType type ;

    private BigDecimal value ;

    private BigDecimal amount ;

    @JsonIgnore
    private Account account ;

    private String accountId ;


    @JsonIgnore
    private Entity entity ;


}
