package com.pruebatecnica.backendservice.usecases;

import com.pruebatecnica.backendservice.dtos.Account;
import com.pruebatecnica.backendservice.dtos.Transaction;

import java.util.List;
import java.util.Map;

public interface ITransactionCreateUseCase {

<<<<<<< HEAD
    List<Transaction> create(List<Transaction> accounts) throws IllegalArgumentException ;
=======
    public Map<String,String> create(List<Transaction> accounts) throws IllegalArgumentException ;
>>>>>>> 0b2c909d87938cf082da51547a4e358275d7ae49

}
