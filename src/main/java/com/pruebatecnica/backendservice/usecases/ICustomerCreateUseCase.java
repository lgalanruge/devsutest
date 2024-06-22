package com.pruebatecnica.backendservice.usecases;

import com.pruebatecnica.backendservice.dtos.Account;
import com.pruebatecnica.backendservice.dtos.Customer;

import java.util.List;
import java.util.Map;

public interface ICustomerCreateUseCase {

    public String create(Customer  customer) throws IllegalArgumentException ;

}
