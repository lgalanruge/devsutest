package com.pruebatecnica.backendservice.usecases;

import com.pruebatecnica.backendservice.dtos.Account;

import java.util.List;
import java.util.Map;

public interface IAccountReadUseCase {

    public List<Account> getByParams (Map<String, String > params) ;

    public Account getById(String id ) ;

}
