package com.pruebatecnica.backendservice.usecases;

import com.pruebatecnica.backendservice.dtos.Account;
import com.pruebatecnica.backendservice.dtos.Customer;

import java.util.List;
import java.util.Map;

public interface ICustomerCreateUseCase {


    public List<Customer> create(List<Customer>  customer) throws IllegalArgumentException ;


}
