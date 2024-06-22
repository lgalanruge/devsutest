package com.pruebatecnica.backendservice.usecases.impl;

import com.pruebatecnica.backendservice.dtos.Account;
import com.pruebatecnica.backendservice.usecases.IAccountCreateUseCase;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class AccountCreateUseCase implements IAccountCreateUseCase {


    @Override
    public Map<String, String> create(List<Account> accounts) throws IllegalArgumentException {
        return Map.of();
    }
}
