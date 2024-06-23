package com.pruebatecnica.backendservice.dtos;

import com.pruebatecnica.backendservice.utils.Status;
import lombok.Data;


import java.util.List;

@Data
public class Customer extends  Person{

    private String customerId ;

    private  String passWord ;

    private Status status ;

    private Entity entity ;

    private List<Account> account ;



}
