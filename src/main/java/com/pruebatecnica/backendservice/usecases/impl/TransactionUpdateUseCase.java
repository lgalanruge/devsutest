package com.pruebatecnica.backendservice.usecases.impl;

import com.pruebatecnica.backendservice.dtos.Account;
import com.pruebatecnica.backendservice.usecases.ITransactionUpdateUseCase;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TransactionUpdateUseCase implements ITransactionUpdateUseCase {


    @Override
    public String create(List<Account> accounts) throws IllegalArgumentException {
        return "";
    }
}
