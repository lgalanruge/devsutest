package com.pruebatecnica.backendservice.services.impl;

import com.pruebatecnica.backendservice.dtos.Transaction;

import com.pruebatecnica.backendservice.entities.TransactionEntity;
import com.pruebatecnica.backendservice.repositories.TransactionRepository;
import com.pruebatecnica.backendservice.services.ITransactionService;
import org.modelmapper.ModelMapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

import java.util.Optional;
import java.util.stream.Collectors;


@Service
public class TransactionService implements ITransactionService {

    @Autowired
    TransactionRepository repository ;


    ModelMapper modelMapper = new ModelMapper();

    @Override
    public List<Transaction> save(List<Transaction> transactions) {
        return repository.saveAll(
                transactions
                        .stream()
                        .map(value -> modelMapper.map(value, TransactionEntity.class))
                        .collect(Collectors.toList())
        )
                .stream()
                .map(value -> modelMapper.map(value , Transaction.class))
                .collect(Collectors.toList());

    }

    @Override
    public Transaction getById(String id) {

        Optional<TransactionEntity> transaction = repository.findById(id);
        return transaction.map(transactionEntity -> modelMapper.map(transactionEntity, Transaction.class)).orElse(null);

    }

    @Override
    public List<Transaction> getByParams(Map<String, String> params) {

        return repository
                .findAll()
                .stream()
                .map(value -> modelMapper.map(value, Transaction.class))
                .collect(Collectors.toList());

    }
}
