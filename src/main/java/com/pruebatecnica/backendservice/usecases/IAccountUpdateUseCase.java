package com.pruebatecnica.backendservice.usecases;

import com.pruebatecnica.backendservice.dtos.Account;

import java.util.List;

public interface IAccountUpdateUseCase {

    List<Account> update (List<Account> accounts) throws IllegalArgumentException ;

}
