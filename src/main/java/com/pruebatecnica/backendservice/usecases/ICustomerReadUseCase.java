package com.pruebatecnica.backendservice.usecases;

import com.pruebatecnica.backendservice.dtos.Account;
import com.pruebatecnica.backendservice.dtos.Customer;

import java.util.List;
import java.util.Map;

public interface ICustomerReadUseCase {

     List<Customer> getByParams (Map<String, String > params) ;

     Customer getById(String id ) ;

}
