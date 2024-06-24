package com.pruebatecnica.backendservice.usecases.impl;

import com.pruebatecnica.backendservice.dtos.Account;
import com.pruebatecnica.backendservice.dtos.Transaction;

import com.pruebatecnica.backendservice.services.ITransactionService;
import com.pruebatecnica.backendservice.services.impl.EntityService;
import com.pruebatecnica.backendservice.usecases.ITransactionCreateUseCase;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Calendar;
import java.util.List;
import java.util.Map;
import java.util.UUID;

@Service
public class TransactionCreateUseCase implements ITransactionCreateUseCase {


    @Autowired
    ITransactionService service ;

    @Override
    public List<Transaction> create(List<Transaction> transactions) throws IllegalArgumentException {

        transactions.forEach(
                value -> {
                    value.setId(UUID.randomUUID().toString());
                    value.setDate(value.getDate() == null ? LocalDate.now() : value.getDate());

                }
        );
        return service.save(transactions);

    }
}
