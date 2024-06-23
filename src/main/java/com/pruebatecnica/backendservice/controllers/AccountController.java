package com.pruebatecnica.backendservice.controllers;

import com.pruebatecnica.backendservice.dtos.Account;
import com.pruebatecnica.backendservice.usecases.IAccountCreateUseCase;
import com.pruebatecnica.backendservice.usecases.IAccountReadUseCase;
import com.pruebatecnica.backendservice.usecases.IAccountUpdateUseCase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("cuentas")
public class AccountController {

    @Autowired
    IAccountCreateUseCase createUseCase ;

    @Autowired
    IAccountUpdateUseCase updateUseCase ;

    @Autowired
    IAccountReadUseCase readUseCase ;

    @GetMapping("/{id}")
    public ResponseEntity<Account> getById(@PathVariable String id){
        Account account = readUseCase.getById(id);
        if(account == null)
            new ResponseEntity<>( HttpStatus.NOT_FOUND );
        return new ResponseEntity<>(account , HttpStatus.OK );
    }

    @GetMapping("")
    public ResponseEntity<List<Account>> getByParam(@RequestParam Map<String, String> values){
        List<Account> accounts = readUseCase.getByParams(values);
        if(accounts.isEmpty())
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        return new ResponseEntity<>(accounts, HttpStatus.OK );
    }

    @PostMapping("")
    public ResponseEntity<List<Account>> post(@RequestBody List<Account> accounts){
        String message = "" ;
        try{
            List<Account> result = createUseCase.create(accounts);
            return new ResponseEntity<>(result, HttpStatus.CREATED );
        }catch (Exception e){
            message = e.getMessage();
        }
        HttpHeaders headers = new HttpHeaders();
        headers.set("errorMessage", message);
        return new ResponseEntity<>(headers,  HttpStatus.NOT_IMPLEMENTED );
    }

    @PutMapping("")
    public ResponseEntity<Void> put(@RequestBody List<Account> accounts){
        String message = "" ;
        try{

            updateUseCase.update(accounts);

            return new ResponseEntity<>( HttpStatus.ACCEPTED );
        }catch (Exception e){
            message = e.getMessage();
        }
        HttpHeaders headers = new HttpHeaders();
        headers.set("errorMessage", message);
        return new ResponseEntity<>(headers,  HttpStatus.NOT_MODIFIED );

    }

    @PatchMapping("/{id}")
    public ResponseEntity<Void> patch(@PathVariable String id , @RequestBody Object body){
        String message = "" ;
        try{
            Map<String, String> result = new HashMap<>();

            return new ResponseEntity<>( HttpStatus.OK );
        }catch (Exception e){
            message = e.getMessage();
        }
        HttpHeaders headers = new HttpHeaders();
        headers.set("errorMessage", message);
        return new ResponseEntity<>(headers,  HttpStatus.NOT_MODIFIED );
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable String id ){
        return new ResponseEntity<>( HttpStatus.NOT_IMPLEMENTED );
    }
}
