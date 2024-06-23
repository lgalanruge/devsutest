package com.pruebatecnica.backendservice.usecases.impl;

import com.pruebatecnica.backendservice.dtos.Account;
import com.pruebatecnica.backendservice.dtos.Customer;

import com.pruebatecnica.backendservice.services.ICustomerService;
import com.pruebatecnica.backendservice.services.impl.CustomerService;
import com.pruebatecnica.backendservice.usecases.ICustomerReadUseCase;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class CustomerReadUseCase implements ICustomerReadUseCase {


    @Autowired
    ICustomerService service ;

    @Override
    public List<Customer> getByParams(Map<String, String> params) {
        return service.getByParams(params);

    }

    @Override
    public Customer getById(String id) {

        return service.getById(id);

    }
}
