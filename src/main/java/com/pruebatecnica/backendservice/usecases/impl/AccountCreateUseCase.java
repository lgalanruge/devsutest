package com.pruebatecnica.backendservice.usecases.impl;

import com.pruebatecnica.backendservice.dtos.Account;
<<<<<<< HEAD
import com.pruebatecnica.backendservice.services.IAccountService;
import com.pruebatecnica.backendservice.services.impl.AccountService;
import com.pruebatecnica.backendservice.usecases.IAccountCreateUseCase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
=======
import com.pruebatecnica.backendservice.usecases.IAccountCreateUseCase;
import org.springframework.stereotype.Service;

>>>>>>> 0b2c909d87938cf082da51547a4e358275d7ae49
import java.util.List;
import java.util.Map;

@Service
public class AccountCreateUseCase implements IAccountCreateUseCase {

<<<<<<< HEAD
    @Autowired
    IAccountService service ;


    @Override
    public List<Account> create(List<Account> accounts) throws IllegalArgumentException {
        return service.save(accounts);
    }

=======

    @Override
    public Map<String, String> create(List<Account> accounts) throws IllegalArgumentException {
        return Map.of();
    }
>>>>>>> 0b2c909d87938cf082da51547a4e358275d7ae49
}
