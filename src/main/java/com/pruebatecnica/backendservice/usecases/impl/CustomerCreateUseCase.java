package com.pruebatecnica.backendservice.usecases.impl;

import com.pruebatecnica.backendservice.dtos.Account;
import com.pruebatecnica.backendservice.dtos.Customer;

import com.pruebatecnica.backendservice.services.ICustomerService;
import com.pruebatecnica.backendservice.services.impl.EntityService;
import com.pruebatecnica.backendservice.usecases.ICustomerCreateUseCase;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.UUID;

@Service
public class CustomerCreateUseCase implements ICustomerCreateUseCase {


    @Autowired
    ICustomerService service ;

    @Autowired
    EntityService entityService ;

    @Override
    public List<Customer> create(List<Customer>  customers) throws IllegalArgumentException {

        customers
                .forEach( value -> {
                    value.setId(UUID.randomUUID().toString());
                    value.setCustomerId(UUID.randomUUID().toString());
                    value.setEntity(entityService.getDto());
                    value.setAccount(new ArrayList<>());
                }) ;

        return service.save(customers) ;

    }
}
