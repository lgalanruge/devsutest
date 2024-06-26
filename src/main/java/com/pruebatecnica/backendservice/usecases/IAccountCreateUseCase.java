package com.pruebatecnica.backendservice.usecases;

import com.pruebatecnica.backendservice.dtos.Account;

import java.util.List;
import java.util.Map;

public interface IAccountCreateUseCase {


    public List<Account> create(List<Account> accounts) throws IllegalArgumentException ;


}
