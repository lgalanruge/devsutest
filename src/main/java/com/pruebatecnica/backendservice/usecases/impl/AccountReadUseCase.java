package com.pruebatecnica.backendservice.usecases.impl;

import com.pruebatecnica.backendservice.dtos.Account;
import com.pruebatecnica.backendservice.usecases.IAccountReadUseCase;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class AccountReadUseCase implements IAccountReadUseCase {

    @Override
    public List<Account> getByParams(Map<String, String> params) {
        return List.of();
    }

    @Override
    public Account getById(String id) {
        return null;
    }
}
