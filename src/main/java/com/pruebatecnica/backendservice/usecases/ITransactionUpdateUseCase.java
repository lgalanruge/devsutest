package com.pruebatecnica.backendservice.usecases;

import com.pruebatecnica.backendservice.dtos.Account;
<<<<<<< HEAD
import com.pruebatecnica.backendservice.dtos.Customer;
import com.pruebatecnica.backendservice.dtos.Transaction;
=======
>>>>>>> 0b2c909d87938cf082da51547a4e358275d7ae49

import java.util.List;

public interface ITransactionUpdateUseCase {

<<<<<<< HEAD

    List<Transaction> update (List<Transaction> Customer) throws IllegalArgumentException ;
=======
    public String create(List<Account> accounts) throws IllegalArgumentException ;

>>>>>>> 0b2c909d87938cf082da51547a4e358275d7ae49
}
