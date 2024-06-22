package com.pruebatecnica.backendservice.usecases;

import com.pruebatecnica.backendservice.dtos.Account;
import com.pruebatecnica.backendservice.dtos.Customer;
import com.pruebatecnica.backendservice.dtos.Transaction;

import java.util.List;
import java.util.Map;

public interface ITransactionReadUseCase {

    public List<Transaction> getByParams (Map<String, String > params) ;

    public Transaction getById(String id ) ;

}
