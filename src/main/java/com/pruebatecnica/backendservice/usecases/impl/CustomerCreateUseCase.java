package com.pruebatecnica.backendservice.usecases.impl;

import com.pruebatecnica.backendservice.dtos.Account;
import com.pruebatecnica.backendservice.dtos.Customer;
import com.pruebatecnica.backendservice.services.ICustomerService;
import com.pruebatecnica.backendservice.usecases.ICustomerCreateUseCase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class CustomerCreateUseCase implements ICustomerCreateUseCase {

    @Autowired
    ICustomerService service ;

    @Override
    public List<Customer> create(List<Customer>  customers) throws IllegalArgumentException {
        return service.save(customers) ;
    }
}
