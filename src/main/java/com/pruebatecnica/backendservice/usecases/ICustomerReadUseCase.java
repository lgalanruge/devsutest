package com.pruebatecnica.backendservice.usecases;

import com.pruebatecnica.backendservice.dtos.Account;
import com.pruebatecnica.backendservice.dtos.Customer;

import java.util.List;
import java.util.Map;

public interface ICustomerReadUseCase {

    public List<Customer> getByParams (Map<String, String > params) ;

    public Customer getById(String id ) ;

}
