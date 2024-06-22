package com.pruebatecnica.backendservice.services;


import com.pruebatecnica.backendservice.dtos.Customer;

import java.util.List;
import java.util.Map;

public interface ICustomerService {

    public List<Customer> save(List<Customer> account) ;

    public Customer getById(String id) ;

    public List<Customer> getByParams(Map<String, String> params) ;

}
