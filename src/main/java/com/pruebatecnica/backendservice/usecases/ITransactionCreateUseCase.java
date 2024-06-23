package com.pruebatecnica.backendservice.usecases;

import com.pruebatecnica.backendservice.dtos.Account;
import com.pruebatecnica.backendservice.dtos.Transaction;

import java.util.List;
import java.util.Map;

public interface ITransactionCreateUseCase {


    List<Transaction> create(List<Transaction> accounts) throws IllegalArgumentException ;


}
