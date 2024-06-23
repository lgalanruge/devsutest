package com.pruebatecnica.backendservice.usecases;


import com.pruebatecnica.backendservice.dtos.Transaction;


import java.util.List;

public interface ITransactionUpdateUseCase {

    List<Transaction> update (List<Transaction> Customer) throws IllegalArgumentException ;

}
