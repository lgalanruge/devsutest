package com.pruebatecnica.backendservice.services;

import com.pruebatecnica.backendservice.dtos.Transaction;

import java.util.List;
import java.util.Map;

public interface ITransactionService {

<<<<<<< HEAD
    public List<Transaction> save(List<Transaction> transactions) ;
=======
    public String save(List<Transaction> account) ;
>>>>>>> 0b2c909d87938cf082da51547a4e358275d7ae49

    public Transaction getById(String id) ;

    public List<Transaction> getByParams(Map<String, String> params) ;

}
