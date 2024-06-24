package com.pruebatecnica.backendservice.controllers;


import com.pruebatecnica.backendservice.dtos.Transaction;
import com.pruebatecnica.backendservice.usecases.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Slf4j
@RestController
@RequestMapping("movimientos")
public class TransactionController {

    @Autowired
    ITransactionCreateUseCase createUseCase ;

    @Autowired
    ITransactionUpdateUseCase updateUseCase ;

    @Autowired
    ITransactionReadUseCase readUseCase ;

    @GetMapping("/{id}")
    public ResponseEntity<Transaction> getById(@PathVariable String id){
        Transaction transaction = readUseCase.getById(id);
        if(transaction == null)
            new ResponseEntity<>( HttpStatus.NOT_FOUND );

        return new ResponseEntity<>(transaction , HttpStatus.OK );

    }

    @GetMapping("")
    public ResponseEntity<List<Transaction>> getByParam(@RequestParam Map<String, String> values){
        List<Transaction> transactions = readUseCase.getByParams(values);
        if(transactions.isEmpty())
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        return new ResponseEntity<>(transactions, HttpStatus.OK );
    }

    @PostMapping("")

    public ResponseEntity<List<Transaction>> post(@RequestBody List<Transaction> transactions){
        String message = "" ;
        try{
            List<Transaction> results = createUseCase.create(transactions);
            return new ResponseEntity<>(results, HttpStatus.CREATED );

        }catch (Exception e){
            log.error(e.getMessage(), e);
            message = e.getMessage();
        }
        HttpHeaders headers = new HttpHeaders();
        headers.set("errorMessage", message);
        return new ResponseEntity<>(headers,  HttpStatus.NOT_IMPLEMENTED );
    }

    @PutMapping("")
    public ResponseEntity<Void> put(@RequestBody List<Transaction> transactions){
        try{

            updateUseCase.update(transactions);

            Map<String, String> result = new HashMap<>();

            return new ResponseEntity<>( HttpStatus.ACCEPTED );
        }catch (Exception e){

        }
        return new ResponseEntity<>( HttpStatus.NOT_MODIFIED );
    }

    @PatchMapping("/{id}")
    public ResponseEntity<Void> patch(@PathVariable String id , @RequestBody Transaction body){
        try{
            Map<String, String> result = new HashMap<>();

            return new ResponseEntity<>( HttpStatus.ACCEPTED );
        }catch (Exception e){

        }
        return new ResponseEntity<>( HttpStatus.NOT_MODIFIED );
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable String id ){
        return new ResponseEntity<>( HttpStatus.NOT_IMPLEMENTED );
    }
}
