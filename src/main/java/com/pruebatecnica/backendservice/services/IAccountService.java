package com.pruebatecnica.backendservice.services;

import com.pruebatecnica.backendservice.dtos.Account;

import java.util.List;
import java.util.Map;

public interface IAccountService {

    List<Account> save(List<Account> account) ;

    Account getById(String id) ;

    List<Account> getByParams(Map<String, String> params) ;

}
