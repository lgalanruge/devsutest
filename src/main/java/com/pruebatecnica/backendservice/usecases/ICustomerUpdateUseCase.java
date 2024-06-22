package com.pruebatecnica.backendservice.usecases;

import com.pruebatecnica.backendservice.dtos.Account;

import java.util.List;

public interface ICustomerUpdateUseCase {

    public String create(List<Account> accounts) throws IllegalArgumentException ;

}
