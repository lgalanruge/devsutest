package com.pruebatecnica.backendservice.usecases.impl;

import com.pruebatecnica.backendservice.dtos.Account;
import com.pruebatecnica.backendservice.dtos.Transaction;
import com.pruebatecnica.backendservice.usecases.ITransactionCreateUseCase;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class TransactionCreateUseCase implements ITransactionCreateUseCase {


    @Override
    public Map<String, String> create(List<Transaction> accounts) throws IllegalArgumentException {
        return Map.of();
    }
}
