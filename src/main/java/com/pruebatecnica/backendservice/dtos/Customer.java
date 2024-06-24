package com.pruebatecnica.backendservice.dtos;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.pruebatecnica.backendservice.utils.Status;
import lombok.Data;


import java.util.List;

@Data
public class Customer extends  Person{

    private String customerId ;

    private  String passWord ;

    private Status status ;

    @JsonIgnore
    private Entity entity ;

    @JsonIgnore
    private List<Account> account ;



}
