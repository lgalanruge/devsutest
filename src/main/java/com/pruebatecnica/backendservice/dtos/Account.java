package com.pruebatecnica.backendservice.dtos;

import com.pruebatecnica.backendservice.utils.AccountType;
import com.pruebatecnica.backendservice.utils.Status;
import lombok.Data;

@Data
public class Account {


    private  Long accountNumber ;

    private Double amount ;

    private Status status ;

    private String id ;

    private AccountType type ;

    private Entity entity ;

}
