package com.pruebatecnica.backendservice.usecases.impl;

import com.pruebatecnica.backendservice.dtos.Account;
import com.pruebatecnica.backendservice.dtos.Transaction;
import com.pruebatecnica.backendservice.services.ICustomerService;
import com.pruebatecnica.backendservice.services.ITransactionService;
import com.pruebatecnica.backendservice.usecases.ITransactionCreateUseCase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class TransactionCreateUseCase implements ITransactionCreateUseCase {

    @Autowired
    ITransactionService service ;

    @Override
    public List<Transaction> create(List<Transaction> transactions) throws IllegalArgumentException {

        return service.save(transactions);
    }
}
