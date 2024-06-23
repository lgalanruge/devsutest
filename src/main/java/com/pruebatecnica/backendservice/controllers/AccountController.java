package com.pruebatecnica.backendservice.controllers;

import com.pruebatecnica.backendservice.dtos.Account;
import com.pruebatecnica.backendservice.usecases.IAccountCreateUseCase;
import com.pruebatecnica.backendservice.usecases.IAccountReadUseCase;
import com.pruebatecnica.backendservice.usecases.IAccountUpdateUseCase;
import org.springframework.beans.factory.annotation.Autowired;
<<<<<<< HEAD
import org.springframework.http.HttpHeaders;
=======
>>>>>>> 0b2c909d87938cf082da51547a4e358275d7ae49
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
<<<<<<< HEAD
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
=======
    public ResponseEntity<Map<String, String>> post(@RequestBody List<Account> accounts){
        try{
            Map<String, String> result = createUseCase.create(accounts);
            return new ResponseEntity<>(result, HttpStatus.CREATED );
        }catch (Exception e){

        }
        return new ResponseEntity<>( HttpStatus.NOT_IMPLEMENTED );
>>>>>>> 0b2c909d87938cf082da51547a4e358275d7ae49
    }

    @PutMapping("")
    public ResponseEntity<Void> put(@RequestBody List<Account> accounts){
<<<<<<< HEAD
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
=======
        try{
            Map<String, String> result = new HashMap<>();

            return new ResponseEntity<>( HttpStatus.ACCEPTED );
        }catch (Exception e){

        }
        return new ResponseEntity<>( HttpStatus.NOT_MODIFIED );
>>>>>>> 0b2c909d87938cf082da51547a4e358275d7ae49

    }

    @PatchMapping("/{id}")
    public ResponseEntity<Void> patch(@PathVariable String id , @RequestBody Object body){
<<<<<<< HEAD
        String message = "" ;
=======
>>>>>>> 0b2c909d87938cf082da51547a4e358275d7ae49
        try{
            Map<String, String> result = new HashMap<>();

            return new ResponseEntity<>( HttpStatus.OK );
        }catch (Exception e){
<<<<<<< HEAD
            message = e.getMessage();
        }
        HttpHeaders headers = new HttpHeaders();
        headers.set("errorMessage", message);
        return new ResponseEntity<>(headers,  HttpStatus.NOT_MODIFIED );
=======

        }

        return new ResponseEntity<>( HttpStatus.NOT_MODIFIED );
>>>>>>> 0b2c909d87938cf082da51547a4e358275d7ae49
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable String id ){
        return new ResponseEntity<>( HttpStatus.NOT_IMPLEMENTED );
    }
}
