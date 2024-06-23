package com.pruebatecnica.backendservice.usecases.impl;

import com.pruebatecnica.backendservice.dtos.Account;
import com.pruebatecnica.backendservice.dtos.Transaction;

import com.pruebatecnica.backendservice.services.ITransactionService;
import com.pruebatecnica.backendservice.usecases.ITransactionReadUseCase;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class TransactionReadUseCase implements ITransactionReadUseCase {


    @Autowired
    ITransactionService service ;

    @Override
    public List<Transaction> getByParams(Map<String, String> params) {
        return service.getByParams(params);

    }

    @Override
    public Transaction getById(String id) {

        return service.getById(id);

    }
}
