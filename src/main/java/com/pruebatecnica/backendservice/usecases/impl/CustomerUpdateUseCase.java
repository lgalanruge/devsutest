package com.pruebatecnica.backendservice.usecases.impl;

import com.pruebatecnica.backendservice.dtos.Account;

import com.pruebatecnica.backendservice.dtos.Customer;
import com.pruebatecnica.backendservice.services.ICustomerService;
import com.pruebatecnica.backendservice.usecases.ICustomerUpdateUseCase;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerUpdateUseCase implements ICustomerUpdateUseCase {


    @Autowired
    ICustomerService service ;


    @Override
    public List<Customer> update(List<Account> Customer) throws IllegalArgumentException {
        return List.of();

    }
}
