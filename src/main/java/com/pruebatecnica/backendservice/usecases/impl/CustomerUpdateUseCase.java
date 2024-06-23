package com.pruebatecnica.backendservice.usecases.impl;

import com.pruebatecnica.backendservice.dtos.Account;
<<<<<<< HEAD
import com.pruebatecnica.backendservice.dtos.Customer;
import com.pruebatecnica.backendservice.services.ICustomerService;
import com.pruebatecnica.backendservice.usecases.ICustomerUpdateUseCase;
import org.springframework.beans.factory.annotation.Autowired;
=======
import com.pruebatecnica.backendservice.usecases.ICustomerUpdateUseCase;
>>>>>>> 0b2c909d87938cf082da51547a4e358275d7ae49
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerUpdateUseCase implements ICustomerUpdateUseCase {

<<<<<<< HEAD
    @Autowired
    ICustomerService service ;


    @Override
    public List<Customer> update(List<Account> Customer) throws IllegalArgumentException {
        return List.of();
=======

    @Override
    public String create(List<Account> accounts) throws IllegalArgumentException {
        return "";
>>>>>>> 0b2c909d87938cf082da51547a4e358275d7ae49
    }
}
