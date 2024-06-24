package com.pruebatecnica.backendservice.dtos;

import com.pruebatecnica.backendservice.utils.AccountType;
import com.pruebatecnica.backendservice.utils.Status;
import lombok.Data;


import java.util.List;


@Data
public class Account {


    private  Long accountNumber ;

    private Double amount ;

    private Status status ;

    private String id ;

    private AccountType type ;

    private Entity entity ;

    private List<Transaction> transactions ;

    private Customer customerId ;


}
