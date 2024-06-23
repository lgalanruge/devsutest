package com.pruebatecnica.backendservice.usecases.impl;

import com.pruebatecnica.backendservice.dtos.Account;
import com.pruebatecnica.backendservice.dtos.Customer;
<<<<<<< HEAD
import com.pruebatecnica.backendservice.services.ICustomerService;
import com.pruebatecnica.backendservice.services.impl.CustomerService;
import com.pruebatecnica.backendservice.usecases.ICustomerReadUseCase;
import org.springframework.beans.factory.annotation.Autowired;
=======
import com.pruebatecnica.backendservice.usecases.ICustomerReadUseCase;
>>>>>>> 0b2c909d87938cf082da51547a4e358275d7ae49
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class CustomerReadUseCase implements ICustomerReadUseCase {

<<<<<<< HEAD
    @Autowired
    ICustomerService service ;

    @Override
    public List<Customer> getByParams(Map<String, String> params) {
        return service.getByParams(params);
=======

    @Override
    public List<Customer> getByParams(Map<String, String> params) {
        return List.of();
>>>>>>> 0b2c909d87938cf082da51547a4e358275d7ae49
    }

    @Override
    public Customer getById(String id) {
<<<<<<< HEAD
        return service.getById(id);
=======
        return null;
>>>>>>> 0b2c909d87938cf082da51547a4e358275d7ae49
    }
}
