package com.pruebatecnica.backendservice.usecases.impl;

import com.pruebatecnica.backendservice.dtos.Account;
import com.pruebatecnica.backendservice.dtos.Transaction;
<<<<<<< HEAD
import com.pruebatecnica.backendservice.services.ICustomerService;
import com.pruebatecnica.backendservice.services.ITransactionService;
import com.pruebatecnica.backendservice.usecases.ITransactionCreateUseCase;
import org.springframework.beans.factory.annotation.Autowired;
=======
import com.pruebatecnica.backendservice.usecases.ITransactionCreateUseCase;
>>>>>>> 0b2c909d87938cf082da51547a4e358275d7ae49
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class TransactionCreateUseCase implements ITransactionCreateUseCase {

<<<<<<< HEAD
    @Autowired
    ITransactionService service ;

    @Override
    public List<Transaction> create(List<Transaction> transactions) throws IllegalArgumentException {

        return service.save(transactions);
=======

    @Override
    public Map<String, String> create(List<Transaction> accounts) throws IllegalArgumentException {
        return Map.of();
>>>>>>> 0b2c909d87938cf082da51547a4e358275d7ae49
    }
}
