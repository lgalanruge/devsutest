package com.pruebatecnica.backendservice.dtos;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.pruebatecnica.backendservice.utils.AccountType;
import com.pruebatecnica.backendservice.utils.Status;
import lombok.Data;


import java.math.BigDecimal;
import java.util.List;


@Data
public class Account {


    private  Long accountNumber ;

    private BigDecimal amount ;

    private Status status ;

    private String id ;

    private AccountType type ;


    private Entity entity ;


    private List<Transaction> transactions ;

    @JsonIgnore
    private Customer customer ;

    private String customerId ;




}
