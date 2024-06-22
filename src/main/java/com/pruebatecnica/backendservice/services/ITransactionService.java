package com.pruebatecnica.backendservice.services;

import com.pruebatecnica.backendservice.dtos.Transaction;

import java.util.List;
import java.util.Map;

public interface ITransactionService {

    public String save(List<Transaction> account) ;

    public Transaction getById(String id) ;

    public List<Transaction> getByParams(Map<String, String> params) ;

}
