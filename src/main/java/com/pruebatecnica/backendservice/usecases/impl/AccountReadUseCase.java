package com.pruebatecnica.backendservice.usecases.impl;

import com.pruebatecnica.backendservice.dtos.Account;

import com.pruebatecnica.backendservice.services.IAccountService;
import com.pruebatecnica.backendservice.usecases.IAccountReadUseCase;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class AccountReadUseCase implements IAccountReadUseCase {


    @Autowired
    IAccountService service ;

    @Override
    public List<Account> getByParams(Map<String, String> params) {

        return service.getByParams(params);

    }

    @Override
    public Account getById(String id) {

        return service.getById(id);

    }
}
