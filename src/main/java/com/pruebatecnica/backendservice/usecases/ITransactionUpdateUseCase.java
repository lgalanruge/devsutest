package com.pruebatecnica.backendservice.usecases;

import com.pruebatecnica.backendservice.dtos.Account;

import java.util.List;

public interface ITransactionUpdateUseCase {

    public String create(List<Account> accounts) throws IllegalArgumentException ;

}
