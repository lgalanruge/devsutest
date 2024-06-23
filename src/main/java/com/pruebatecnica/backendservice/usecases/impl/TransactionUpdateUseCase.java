package com.pruebatecnica.backendservice.usecases.impl;

import com.pruebatecnica.backendservice.dtos.Account;
import com.pruebatecnica.backendservice.dtos.Transaction;
import com.pruebatecnica.backendservice.services.ITransactionService;
import com.pruebatecnica.backendservice.usecases.ITransactionUpdateUseCase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TransactionUpdateUseCase implements ITransactionUpdateUseCase {

    @Autowired
    ITransactionService service ;


    @Override
    public List<Transaction> update(List<Transaction> transactions) throws IllegalArgumentException {

        return service.save(transactions);
    }
}
