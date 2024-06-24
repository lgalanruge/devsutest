package com.pruebatecnica.backendservice.services.impl;

import com.pruebatecnica.backendservice.dtos.Account;
import com.pruebatecnica.backendservice.dtos.Customer;
import com.pruebatecnica.backendservice.dtos.Entity;
import com.pruebatecnica.backendservice.dtos.Transaction;
import com.pruebatecnica.backendservice.entities.AccountEntity;
import com.pruebatecnica.backendservice.entities.CustomerEntity;
import com.pruebatecnica.backendservice.entities.EntityEntity;
import com.pruebatecnica.backendservice.entities.TransactionEntity;
import com.pruebatecnica.backendservice.repositories.AccountRepository;
import com.pruebatecnica.backendservice.repositories.CustomerRepository;
import com.pruebatecnica.backendservice.services.IAccountService;
import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.function.Function;
import java.util.stream.Collectors;

@Service
public class AccountService implements IAccountService {

    private static final Logger log = LoggerFactory.getLogger(AccountService.class);
    @Autowired
    AccountRepository repository ;

    ModelMapper modelMapper = new ModelMapper();


    @Override
    public List<Account>  save(List<Account> accounts) {

        return repository
                .saveAllAndFlush(accounts
                        .stream()
                        .map(value -> toEntityMap.apply(value))
                        .collect(Collectors.toList()))
                .stream()
                .map(value -> modelMapper.map(value, Account.class))
                .collect(Collectors.toList()) ;



    }

    @Override
    public Account getById(String id) {
        Optional<AccountEntity> entity = repository.findById(id);

        return entity.map(accountEntity -> toDtoMap.apply(accountEntity)).orElse(null);
    }

    @Override
    public List<Account> getByParams(Map<String, String> params) {
        return repository
                .findAll()
                .stream()
                .map(value -> modelMapper.map(value, Account.class))
                .collect(Collectors.toList());
    }

    Function<Account, AccountEntity> toEntityMap = (dto) -> {
       AccountEntity entity = new AccountEntity();
       entity.setId(dto.getId());
       entity.setEntityId(modelMapper.map(dto.getEntity(), EntityEntity.class));
       entity.setType(dto.getType());
       entity.setAmount(dto.getAmount());
       entity.setAccountNumber(dto.getAccountNumber());
       entity.setStatus(dto.getStatus());
       CustomerEntity customerEntity = new CustomerEntity() ;//  customerRepository.findById(dto.getCustomerId()).get() ;
       customerEntity.setCustomerId(dto.getCustomerId());
       entity.setCustomerId(customerEntity);

       return entity ;
    };

    Function< AccountEntity, Account> toDtoMap = (entity) -> {
        Account dto = new Account();
        dto.setId(entity.getId());

        Entity entity1 = new Entity();
        entity1.setId(entity.getEntityId().getId());
        dto.setEntity (entity1);

        dto.setType(entity.getType());
        dto.setAmount(entity.getAmount());
        dto.setAccountNumber(entity.getAccountNumber());
        dto.setStatus(entity.getStatus());
        Customer customerDto = new Customer() ;
        customerDto.setCustomerId(entity.getCustomerId().getCustomerId());
        dto.setCustomerId(entity.getCustomerId().getCustomerId());
        dto.setCustomer(customerDto);

        if(null == entity.getTransactions() || entity.getTransactions().isEmpty()){
            dto.setTransactions(new ArrayList<>());
        }else{
            List<Transaction> transactions = entity
                    .getTransactions()
                    .stream()
                    .map(this::apply)
                    .collect(Collectors.toList());

            dto.setTransactions(transactions);
        }

        return dto ;
    };
    
    Function<TransactionEntity , Transaction> toDtoTransaction = (ent) -> {
        Transaction transaction = new Transaction(); 
        transaction.setId(ent.getId());
        transaction.setAccountId(ent.getAccountId().getId());
        transaction.setType(ent.getType());
        transaction.setAmount(ent.getAmount());
        transaction.setDate(ent.getDate());
        transaction.setValue(ent.getValue());
        return transaction ; 
    } ;

    private Transaction apply(TransactionEntity value) {
        return toDtoTransaction.apply(value);
    }
}
