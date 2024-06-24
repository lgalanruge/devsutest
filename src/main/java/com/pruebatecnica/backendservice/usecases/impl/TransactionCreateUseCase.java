package com.pruebatecnica.backendservice.usecases.impl;

import com.pruebatecnica.backendservice.dtos.Account;
import com.pruebatecnica.backendservice.dtos.Transaction;

import com.pruebatecnica.backendservice.services.IAccountService;
import com.pruebatecnica.backendservice.services.ITransactionService;
import com.pruebatecnica.backendservice.usecases.IAccountReadUseCase;
import com.pruebatecnica.backendservice.usecases.IAccountUpdateUseCase;
import com.pruebatecnica.backendservice.usecases.ITransactionCreateUseCase;
import com.pruebatecnica.backendservice.utils.TransactionType;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.*;
import java.util.stream.Collectors;

@Service
public class TransactionCreateUseCase implements ITransactionCreateUseCase {


    @Autowired
    ITransactionService transactionService  ;

    @Autowired
    IAccountUpdateUseCase accountUpdateUseCase ;

    @Autowired
    IAccountReadUseCase accountReadUseCase ;

    @Override
    public List<Transaction> create(List<Transaction> transactions) throws IllegalArgumentException {

        List<Transaction> noExistAccounts = new ArrayList<>();
        List<Transaction> noAmountAccounts = new ArrayList<>();


        transactions.forEach(
                value -> {

                    value.setId(UUID.randomUUID().toString());
                    value.setDate(value.getDate() == null ? LocalDate.now() : value.getDate());

                    int validate = checkAccount(value);

                    switch (validate){
                        case -1:
                            noExistAccounts.add(value);
                            break;
                        case -2:
                            noAmountAccounts.add(value);
                            break;
                        default:
                            break;

                    }

                    Account account = new Account();
                    account.setId(value.getAccountId());

                    value.setAccount(account);



                }
        );

        if (!noExistAccounts.isEmpty()){
            throw new IllegalArgumentException("Las cuentas " + noExistAccounts + " no existen."  );
        }

        if (!noAmountAccounts.isEmpty()){
            throw new IllegalArgumentException("Las cuentas " + noAmountAccounts + " no tienen saldo para realizar el movimiento."  );
        }

       transactions
                .forEach( value -> {
                    Account account = updateAccount(value);
                    value.setAccount(account);
                    value.setAmount(account.getAmount());
                });

        return transactionService.save(transactions);

    }

    Integer checkAccount(Transaction transactionId) throws IllegalArgumentException{

        Account account = accountReadUseCase.getById(transactionId.getAccountId());
        if(account == null){
            return -1 ;
        }

        if(transactionId.getType().equals(TransactionType.CREDIT) &&
              account.getAmount().doubleValue() <= 0  ){
            return -2 ;
        }

        return 0 ;
    }

    Account updateAccount(Transaction transactionId) throws IllegalArgumentException{

        Account account = accountReadUseCase.getById(transactionId.getAccountId());

        BigDecimal newAmount = account.getAmount() ;
        if(TransactionType.DEBIT.equals(transactionId.getType())){
            newAmount = newAmount.add(transactionId.getValue());
        }

        if(TransactionType.CREDIT.equals(transactionId.getType())){
            newAmount = newAmount.subtract(transactionId.getValue());
        }

        account.setAmount(newAmount);

        List<Account> accounts = new ArrayList<>() ;
        accounts.add(account);
        accountUpdateUseCase.update(accounts);

        return account ;
    }


}
