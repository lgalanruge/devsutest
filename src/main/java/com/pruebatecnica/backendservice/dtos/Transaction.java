package com.pruebatecnica.backendservice.dtos;

import com.pruebatecnica.backendservice.utils.TransactionType;
import lombok.Data;

import java.util.Date;

@Data
public class Transaction {

    private String id ;

    private Date date ;

    private TransactionType type ;

    private Double value ;

    private Double amount ;

    private Account account ;


}
