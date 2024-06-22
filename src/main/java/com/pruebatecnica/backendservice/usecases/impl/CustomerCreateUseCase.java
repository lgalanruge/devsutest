package com.pruebatecnica.backendservice.usecases.impl;

import com.pruebatecnica.backendservice.dtos.Account;
import com.pruebatecnica.backendservice.dtos.Customer;
import com.pruebatecnica.backendservice.usecases.ICustomerCreateUseCase;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class CustomerCreateUseCase implements ICustomerCreateUseCase {


    @Override
    public String create(Customer  customer) throws IllegalArgumentException {
        return "";
    }
}
