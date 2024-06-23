package com.pruebatecnica.backendservice.usecases.impl;

import com.pruebatecnica.backendservice.dtos.Account;
<<<<<<< HEAD
import com.pruebatecnica.backendservice.services.IAccountService;
import com.pruebatecnica.backendservice.usecases.IAccountReadUseCase;
import org.springframework.beans.factory.annotation.Autowired;
=======
import com.pruebatecnica.backendservice.usecases.IAccountReadUseCase;
>>>>>>> 0b2c909d87938cf082da51547a4e358275d7ae49
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class AccountReadUseCase implements IAccountReadUseCase {

<<<<<<< HEAD
    @Autowired
    IAccountService service ;

    @Override
    public List<Account> getByParams(Map<String, String> params) {

        return service.getByParams(params);
=======
    @Override
    public List<Account> getByParams(Map<String, String> params) {
        return List.of();
>>>>>>> 0b2c909d87938cf082da51547a4e358275d7ae49
    }

    @Override
    public Account getById(String id) {
<<<<<<< HEAD
        return service.getById(id);
=======
        return null;
>>>>>>> 0b2c909d87938cf082da51547a4e358275d7ae49
    }
}
