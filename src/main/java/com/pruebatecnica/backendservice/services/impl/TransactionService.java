package com.pruebatecnica.backendservice.services.impl;

import com.pruebatecnica.backendservice.dtos.Transaction;
<<<<<<< HEAD
import com.pruebatecnica.backendservice.entities.TransactionEntity;
import com.pruebatecnica.backendservice.repositories.TransactionRepository;
import com.pruebatecnica.backendservice.services.ITransactionService;
import org.modelmapper.ModelMapper;
=======
import com.pruebatecnica.backendservice.repositories.TransactionRepository;
import com.pruebatecnica.backendservice.services.ITransactionService;
>>>>>>> 0b2c909d87938cf082da51547a4e358275d7ae49
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
<<<<<<< HEAD
import java.util.Optional;
import java.util.stream.Collectors;
=======
>>>>>>> 0b2c909d87938cf082da51547a4e358275d7ae49

@Service
public class TransactionService implements ITransactionService {

    @Autowired
    TransactionRepository repository ;

<<<<<<< HEAD
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
=======
    @Override
    public String save(List<Transaction> account) {
        return "";
>>>>>>> 0b2c909d87938cf082da51547a4e358275d7ae49
    }

    @Override
    public Transaction getById(String id) {
<<<<<<< HEAD
        Optional<TransactionEntity> transaction = repository.findById(id);
        return transaction.map(transactionEntity -> modelMapper.map(transactionEntity, Transaction.class)).orElse(null);
=======
        return null;
>>>>>>> 0b2c909d87938cf082da51547a4e358275d7ae49
    }

    @Override
    public List<Transaction> getByParams(Map<String, String> params) {
<<<<<<< HEAD
        return repository
                .findAll()
                .stream()
                .map(value -> modelMapper.map(value, Transaction.class))
                .collect(Collectors.toList());
=======
        return List.of();
>>>>>>> 0b2c909d87938cf082da51547a4e358275d7ae49
    }
}
