package com.pruebatecnica.backendservice.controllers;


import com.pruebatecnica.backendservice.dtos.Customer;
import com.pruebatecnica.backendservice.usecases.*;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.HttpHeaders;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("clientes")
public class CustomerController {

    @Autowired
    ICustomerCreateUseCase createUseCase ;

    @Autowired
    ICustomerUpdateUseCase updateUseCase ;

    @Autowired
    ICustomerReadUseCase readUseCase ;


    @GetMapping("/{id}")
    public ResponseEntity<Customer> getById(@PathVariable String id){

        Customer customer = readUseCase.getById(id);
        if(customer == null)
            new ResponseEntity<>( HttpStatus.NOT_FOUND );
        return new ResponseEntity<>(customer , HttpStatus.OK );

    }

    @GetMapping("")
    public ResponseEntity<List<Customer>> getByParam(@RequestParam Map<String, String> values){
        List<Customer> customers = readUseCase.getByParams(values);
        if(customers.isEmpty())
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        return new ResponseEntity<>(customers, HttpStatus.OK );
    }

    @PostMapping("")
    public ResponseEntity<List<Customer>> post(@RequestBody List<Customer> customers){
        String message = "" ;
        try{
            List<Customer> results = createUseCase.create(customers);
            return new ResponseEntity<>(results, HttpStatus.CREATED );
        }catch (Exception e){
            message = e.getMessage();
        }
        HttpHeaders headers  = new HttpHeaders();
        headers.set("errorMessage", message);

        return new ResponseEntity<>(headers,  HttpStatus.NOT_IMPLEMENTED );

    }

    @PutMapping("")
    public ResponseEntity<Void> put(@RequestBody Customer id){
        try{
            Map<String, String> result = new HashMap<>();

            return new ResponseEntity<>( HttpStatus.ACCEPTED );
        }catch (Exception e){

        }
        return new ResponseEntity<>( HttpStatus.NOT_MODIFIED );
    }

    @PatchMapping("/{id}")
    public ResponseEntity<Void> patch(@PathVariable String id , @RequestBody Customer body){
        try{
            Map<String, String> result = new HashMap<>();

            return new ResponseEntity<>( HttpStatus.ACCEPTED );
        }catch (Exception e){

        }
        return new ResponseEntity<>( HttpStatus.NOT_MODIFIED );
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> delete(@PathVariable String id ){
        return new ResponseEntity<>( HttpStatus.NOT_IMPLEMENTED );
    }
}
