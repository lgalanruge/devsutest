package com.pruebatecnica.backendservice.usecases.impl;

import com.pruebatecnica.backendservice.dtos.Account;
import com.pruebatecnica.backendservice.dtos.Transaction;
<<<<<<< HEAD
import com.pruebatecnica.backendservice.services.ITransactionService;
import com.pruebatecnica.backendservice.usecases.ITransactionReadUseCase;
import org.springframework.beans.factory.annotation.Autowired;
=======
import com.pruebatecnica.backendservice.usecases.ITransactionReadUseCase;
>>>>>>> 0b2c909d87938cf082da51547a4e358275d7ae49
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class TransactionReadUseCase implements ITransactionReadUseCase {

<<<<<<< HEAD
    @Autowired
    ITransactionService service ;

    @Override
    public List<Transaction> getByParams(Map<String, String> params) {
        return service.getByParams(params);
=======

    @Override
    public List<Transaction> getByParams(Map<String, String> params) {
        return List.of();
>>>>>>> 0b2c909d87938cf082da51547a4e358275d7ae49
    }

    @Override
    public Transaction getById(String id) {
<<<<<<< HEAD
        return service.getById(id);
=======
        return null;
>>>>>>> 0b2c909d87938cf082da51547a4e358275d7ae49
    }
}
