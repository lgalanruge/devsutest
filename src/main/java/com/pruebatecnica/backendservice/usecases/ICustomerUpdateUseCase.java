package com.pruebatecnica.backendservice.usecases;

import com.pruebatecnica.backendservice.dtos.Account;

import com.pruebatecnica.backendservice.dtos.Customer;


import java.util.List;

public interface ICustomerUpdateUseCase {

    List<Customer> update (List<Account> Customer) throws IllegalArgumentException ;

}
