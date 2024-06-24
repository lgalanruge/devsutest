package com.pruebatecnica.backendservice.services.impl;


import com.pruebatecnica.backendservice.dtos.Customer;
import com.pruebatecnica.backendservice.dtos.Entity;
import com.pruebatecnica.backendservice.entities.CustomerEntity;

import com.pruebatecnica.backendservice.entities.EntityEntity;
import com.pruebatecnica.backendservice.entities.PersonEntity;
import com.pruebatecnica.backendservice.repositories.*;
import com.pruebatecnica.backendservice.services.ICustomerService;


import com.pruebatecnica.backendservice.repositories.CustomerRepository;
import com.pruebatecnica.backendservice.repositories.PersonRepository;
import com.pruebatecnica.backendservice.services.ICustomerService;
import org.modelmapper.ModelMapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

import java.util.function.Function;

import java.util.stream.Collectors;

@Service
public class CustomerService implements ICustomerService {

    @Autowired
    PersonRepository personRepository ;

    @Autowired
    CustomerRepository customerRepository ;

    @Autowired
    EntityService entityService ;

    @Autowired
    private Entity dto ;

    private final ModelMapper modelMapper = new ModelMapper();

    @Override
    public List<Customer> save(List<Customer> customers) {

        customers
                .forEach( value -> {

                    PersonEntity person = new PersonEntity();
                    person.setAddress(value.getAddress());
                    person.setId(value.getId());
                    person.setName(value.getName());
                    person.setAge(value.getAge());
                    person.setGenere(value.getGenere());
                    person.setIdentificationNumber(value.getIdentificationNumber());
                    person.setPhoneNumber(value.getPhoneNumber());

                    personRepository.save(person);

                    CustomerEntity entity = new CustomerEntity();
                    entity.setCustomerId(value.getCustomerId());
                    entity.setStatus(value.getStatus());
                    entity.setPassWord(value.getPassWord());
                    entity.setPersonId(person);
                    entity.setEntityId(entityService.getEntity());

                    customerRepository.save(entity) ;

                });

        return customers;

    }

    @Override
    public Customer getById(String id) {

        Optional<CustomerEntity> entity = customerRepository.findById(id);

        return entity.map(customerEntity -> entityToDtoMap.apply(customerEntity)).orElse(null);


    }

    @Override
    public List<Customer> getByParams(Map<String, String> params) {
        return customerRepository
                .findAll()
                .stream()

                .map(value -> entityToDtoMap.apply(value))
                .collect(Collectors.toList());
    }

    Function<CustomerEntity , Customer > entityToDtoMap = (value) -> {
        Customer customer = new Customer();

        customer.setCustomerId(value.getCustomerId());
        customer.setEntity(null);
        customer.setStatus(value.getStatus());
        customer.setPassWord(value.getPassWord());
        customer.setAge(value.getPersonId().getAge());
        customer.setEntity(modelMapper.map(value.getEntityId(), Entity.class));
        customer.setAccount(new ArrayList<>());

        customer.setAddress(value.getPersonId().getAddress());
        customer.setId(value.getPersonId().getId());
        customer.setGenere(value.getPersonId().getGenere());
        customer.setIdentificationNumber(value.getPersonId().getIdentificationNumber());
        customer.setName(value.getPersonId().getName());
        customer.setPhoneNumber(value.getPersonId().getPhoneNumber());

        return customer ;

    } ;

}
