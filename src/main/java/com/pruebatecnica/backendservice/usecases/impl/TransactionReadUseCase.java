package com.pruebatecnica.backendservice.usecases.impl;

import com.pruebatecnica.backendservice.dtos.Account;
import com.pruebatecnica.backendservice.dtos.Transaction;
import com.pruebatecnica.backendservice.usecases.ITransactionReadUseCase;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class TransactionReadUseCase implements ITransactionReadUseCase {


    @Override
    public List<Transaction> getByParams(Map<String, String> params) {
        return List.of();
    }

    @Override
    public Transaction getById(String id) {
        return null;
    }
}
