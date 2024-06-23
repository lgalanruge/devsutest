package com.pruebatecnica.backendservice.services;

import com.pruebatecnica.backendservice.dtos.Account;

import java.util.List;
import java.util.Map;

public interface IAccountService {

<<<<<<< HEAD
    List<Account> save(List<Account> account) ;

    Account getById(String id) ;

    List<Account> getByParams(Map<String, String> params) ;
=======
    public List<Account>  save(List<Account> account) ;

    public Account getById(String id) ;

    public List<Account> getByParams(Map<String, String> params) ;
>>>>>>> 0b2c909d87938cf082da51547a4e358275d7ae49

}
