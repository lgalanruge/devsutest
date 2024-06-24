package com.pruebatecnica.backendservice.services.impl;

import com.pruebatecnica.backendservice.dtos.Account;
import com.pruebatecnica.backendservice.entities.AccountEntity;
import com.pruebatecnica.backendservice.repositories.AccountRepository;
import com.pruebatecnica.backendservice.services.IAccountService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class AccountService implements IAccountService {

    @Autowired
    AccountRepository repository ;



    ModelMapper modelMapper = new ModelMapper();


    @Override
    public List<Account>  save(List<Account> accounts) {



        return repository
                .saveAll(accounts
                        .stream()
                        .map(value -> modelMapper.map(value, AccountEntity.class))
                        .collect(Collectors.toList()))
                .stream()
                .map(value -> modelMapper.map(value, Account.class))
                .collect(Collectors.toList()) ;

    }

    @Override
    public Account getById(String id) {
        Optional<AccountEntity> entity = repository.findById(id);
        return entity.map(accountEntity -> modelMapper.map(accountEntity, Account.class)).orElse(null);
    }

    @Override
    public List<Account> getByParams(Map<String, String> params) {
        return repository
                .findAll()
                .stream()
                .map(value -> modelMapper.map(value, Account.class))
                .collect(Collectors.toList());
    }
}
