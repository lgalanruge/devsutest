package com.pruebatecnica.backendservice.usecases.impl;

import com.pruebatecnica.backendservice.dtos.Account;
<<<<<<< HEAD
import com.pruebatecnica.backendservice.dtos.Transaction;
import com.pruebatecnica.backendservice.services.ITransactionService;
import com.pruebatecnica.backendservice.usecases.ITransactionUpdateUseCase;
import org.springframework.beans.factory.annotation.Autowired;
=======
import com.pruebatecnica.backendservice.usecases.ITransactionUpdateUseCase;
>>>>>>> 0b2c909d87938cf082da51547a4e358275d7ae49
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TransactionUpdateUseCase implements ITransactionUpdateUseCase {

<<<<<<< HEAD
    @Autowired
    ITransactionService service ;


    @Override
    public List<Transaction> update(List<Transaction> transactions) throws IllegalArgumentException {

        return service.save(transactions);
=======

    @Override
    public String create(List<Account> accounts) throws IllegalArgumentException {
        return "";
>>>>>>> 0b2c909d87938cf082da51547a4e358275d7ae49
    }
}
