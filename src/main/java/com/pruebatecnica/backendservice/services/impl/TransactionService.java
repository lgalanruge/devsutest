package com.pruebatecnica.backendservice.services.impl;

import com.pruebatecnica.backendservice.dtos.Transaction;
import com.pruebatecnica.backendservice.repositories.TransactionRepository;
import com.pruebatecnica.backendservice.services.ITransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class TransactionService implements ITransactionService {

    @Autowired
    TransactionRepository repository ;

    @Override
    public String save(List<Transaction> account) {
        return "";
    }

    @Override
    public Transaction getById(String id) {
        return null;
    }

    @Override
    public List<Transaction> getByParams(Map<String, String> params) {
        return List.of();
    }
}
