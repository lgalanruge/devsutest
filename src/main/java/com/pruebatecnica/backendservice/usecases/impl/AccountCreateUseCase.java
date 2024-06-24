package com.pruebatecnica.backendservice.usecases.impl;

import com.pruebatecnica.backendservice.dtos.Account;

import com.pruebatecnica.backendservice.dtos.Customer;
import com.pruebatecnica.backendservice.services.IAccountService;
import com.pruebatecnica.backendservice.services.impl.AccountService;
import com.pruebatecnica.backendservice.services.impl.EntityService;
import com.pruebatecnica.backendservice.usecases.IAccountCreateUseCase;
import com.pruebatecnica.backendservice.usecases.ICustomerReadUseCase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

import com.pruebatecnica.backendservice.usecases.IAccountCreateUseCase;
import org.springframework.stereotype.Service;

@Service
public class AccountCreateUseCase implements IAccountCreateUseCase {


    @Autowired
    IAccountService service ;

    @Autowired
    EntityService entityService ;

    @Autowired
    ICustomerReadUseCase customerReadUseCase ;


    @Override
    public List<Account> create(List<Account> accounts) throws IllegalArgumentException {

        accounts.forEach(
                value -> {
                    value.setCustomer(customerReadUseCase.getById(value.getCustomerId()));
                    value.setId(UUID.randomUUID().toString());
                    value.setEntity(entityService.getDto());
                    value.setTransactions(new ArrayList<>());
                }
        );

        List<String> withOutCustomers = accounts
                .stream()
                .filter(value -> value.getCustomer() == null)
                .map(value -> "" + value.getAccountNumber())
                .collect(Collectors.toList());

        if(!withOutCustomers.isEmpty()) {
            throw new IllegalArgumentException("No existen clientes registrados para las cuentas " + withOutCustomers);
        }

        return service.save(accounts);
    }




}
