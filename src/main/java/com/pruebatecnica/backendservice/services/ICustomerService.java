package com.pruebatecnica.backendservice.services;


import com.pruebatecnica.backendservice.dtos.Customer;

import java.util.List;
import java.util.Map;

public interface ICustomerService {

     List<Customer> save(List<Customer> account) ;

     Customer getById(String id) ;

     List<Customer> getByParams(Map<String, String> params) ;

}
