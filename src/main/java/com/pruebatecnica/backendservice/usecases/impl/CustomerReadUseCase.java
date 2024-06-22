package com.pruebatecnica.backendservice.usecases.impl;

import com.pruebatecnica.backendservice.dtos.Account;
import com.pruebatecnica.backendservice.dtos.Customer;
import com.pruebatecnica.backendservice.usecases.ICustomerReadUseCase;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class CustomerReadUseCase implements ICustomerReadUseCase {


    @Override
    public List<Customer> getByParams(Map<String, String> params) {
        return List.of();
    }

    @Override
    public Customer getById(String id) {
        return null;
    }
}
