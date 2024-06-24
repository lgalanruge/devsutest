package com.pruebatecnica.backendservice.usecases.impl;

import com.pruebatecnica.backendservice.dtos.Account;

import com.pruebatecnica.backendservice.services.IAccountService;
import com.pruebatecnica.backendservice.services.impl.AccountService;
import com.pruebatecnica.backendservice.services.impl.EntityService;
import com.pruebatecnica.backendservice.usecases.IAccountCreateUseCase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

import com.pruebatecnica.backendservice.usecases.IAccountCreateUseCase;
import org.springframework.stereotype.Service;

@Service
public class AccountCreateUseCase implements IAccountCreateUseCase {


    @Autowired
    IAccountService service ;

    @Autowired
    EntityService entityService ;

    @Override
    public List<Account> create(List<Account> accounts) throws IllegalArgumentException {

        accounts.forEach(
                value -> {
                    value.setId(UUID.randomUUID().toString());
                    value.setEntity(entityService.getDto());
                    value.setTransactions(new ArrayList<>());
                }
        );

        return service.save(accounts);
    }




}
