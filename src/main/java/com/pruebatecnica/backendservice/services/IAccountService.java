package com.pruebatecnica.backendservice.services;

import com.pruebatecnica.backendservice.dtos.Account;

import java.util.List;
import java.util.Map;

public interface IAccountService {

    public List<Account>  save(List<Account> account) ;

    public Account getById(String id) ;

    public List<Account> getByParams(Map<String, String> params) ;

}
