package com.pruebatecnica.backendservice.usecases.impl;

import com.pruebatecnica.backendservice.dtos.Account;
import com.pruebatecnica.backendservice.dtos.Customer;
<<<<<<< HEAD
import com.pruebatecnica.backendservice.services.ICustomerService;
import com.pruebatecnica.backendservice.usecases.ICustomerCreateUseCase;
import org.springframework.beans.factory.annotation.Autowired;
=======
import com.pruebatecnica.backendservice.usecases.ICustomerCreateUseCase;
>>>>>>> 0b2c909d87938cf082da51547a4e358275d7ae49
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class CustomerCreateUseCase implements ICustomerCreateUseCase {

<<<<<<< HEAD
    @Autowired
    ICustomerService service ;

    @Override
    public List<Customer> create(List<Customer>  customers) throws IllegalArgumentException {
        return service.save(customers) ;
=======

    @Override
    public String create(Customer  customer) throws IllegalArgumentException {
        return "";
>>>>>>> 0b2c909d87938cf082da51547a4e358275d7ae49
    }
}
