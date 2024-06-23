package com.pruebatecnica.backendservice.services.impl;


import com.pruebatecnica.backendservice.dtos.Customer;
import com.pruebatecnica.backendservice.entities.CustomerEntity;

import com.pruebatecnica.backendservice.entities.PersonEntity;
import com.pruebatecnica.backendservice.repositories.CustomerRepository;
import com.pruebatecnica.backendservice.repositories.PersonRepository;
import com.pruebatecnica.backendservice.services.ICustomerService;


import com.pruebatecnica.backendservice.repositories.CustomerRepository;
import com.pruebatecnica.backendservice.repositories.PersonRepository;
import com.pruebatecnica.backendservice.services.ICustomerService;
import org.modelmapper.ModelMapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.Optional;

import java.util.UUID;
import java.util.function.Function;

import java.util.stream.Collectors;

@Service
public class CustomerService implements ICustomerService {

    @Autowired
    PersonRepository personRepository ;

    @Autowired
    CustomerRepository customerRepository ;


    @Override
    public List<Customer> save(List<Customer> customers) {

        customers
                .forEach( value -> {

                    PersonEntity person = new PersonEntity();
                    person.setAddress(value.getAddress());

                    String id = value.getId() == null ? UUID.randomUUID().toString() : value.getId();
                    person.setId(id);

                    person.setAge(value.getAge());
                    person.setGenere(value.getGenere());
                    person.setIdentificationNumber(value.getIdentificationNumber());
                    person.setPhoneNumber(value.getPhoneNumber());

                    personRepository.save(person);

                    value.setId(id);

                    CustomerEntity entity = new CustomerEntity();
                    String customerId = value.getCustomerId() == null ? UUID.randomUUID().toString() : value.getCustomerId();
                    entity.setCustomerId(customerId);
                    entity.setStatus(value.getStatus());
                    entity.setPassWord(value.getPassWord());
                    entity.setPersonId(person);

                    value.setCustomerId(customerId);

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

        customer.setAddress(value.getPersonId().getAddress());
        customer.setId(value.getPersonId().getId());
        customer.setGenere(value.getPersonId().getGenere());
        customer.setIdentificationNumber(value.getPersonId().getIdentificationNumber());
        customer.setName(value.getPersonId().getName());
        customer.setPhoneNumber(value.getPersonId().getPhoneNumber());

        return customer ;

    } ;

}
