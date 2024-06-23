package com.pruebatecnica.backendservice.services;

import com.pruebatecnica.backendservice.dtos.Transaction;

import java.util.List;
import java.util.Map;

public interface ITransactionService {


     List<Transaction> save(List<Transaction> transactions) ;

     Transaction getById(String id) ;

     List<Transaction> getByParams(Map<String, String> params) ;

}
