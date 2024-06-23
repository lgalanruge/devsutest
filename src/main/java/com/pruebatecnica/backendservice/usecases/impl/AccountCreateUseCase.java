package com.pruebatecnica.backendservice.usecases.impl;

import com.pruebatecnica.backendservice.dtos.Account;
import com.pruebatecnica.backendservice.services.IAccountService;
import com.pruebatecnica.backendservice.services.impl.AccountService;
import com.pruebatecnica.backendservice.usecases.IAccountCreateUseCase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.Map;

@Service
public class AccountCreateUseCase implements IAccountCreateUseCase {

    @Autowired
    IAccountService service ;


    @Override
    public List<Account> create(List<Account> accounts) throws IllegalArgumentException {
        return service.save(accounts);
    }

}
