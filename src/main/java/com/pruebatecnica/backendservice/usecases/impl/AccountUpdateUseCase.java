package com.pruebatecnica.backendservice.usecases.impl;

<<<<<<< HEAD
import com.pruebatecnica.backendservice.dtos.Account;
import com.pruebatecnica.backendservice.services.IAccountService;
import com.pruebatecnica.backendservice.usecases.IAccountUpdateUseCase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AccountUpdateUseCase implements IAccountUpdateUseCase {

    @Autowired
    IAccountService service ;

    @Override
    public List<Account> update(List<Account> accounts) throws IllegalArgumentException {
        return List.of();
    }
=======
import com.pruebatecnica.backendservice.usecases.IAccountUpdateUseCase;
import org.springframework.stereotype.Service;

@Service
public class AccountUpdateUseCase implements IAccountUpdateUseCase {

>>>>>>> 0b2c909d87938cf082da51547a4e358275d7ae49
}
