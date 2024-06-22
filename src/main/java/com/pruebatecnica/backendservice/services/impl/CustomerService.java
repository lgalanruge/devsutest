package com.pruebatecnica.backendservice.services.impl;


import com.pruebatecnica.backendservice.dtos.Customer;
import com.pruebatecnica.backendservice.entities.CustomerEntity;
import com.pruebatecnica.backendservice.repositories.CustomerRepository;
import com.pruebatecnica.backendservice.repositories.PersonRepository;
import com.pruebatecnica.backendservice.services.ICustomerService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class CustomerService implements ICustomerService {

    @Autowired
    PersonRepository personRepository ;

    @Autowired
    CustomerRepository customerRepository ;

    ModelMapper modelMapper = new ModelMapper();

    @Override
    public List<Customer> save(List<Customer> customers) {
        return customerRepository
                .saveAll(customers
                        .stream()
                        .map( value -> modelMapper.map(value, CustomerEntity.class) )
                        .collect(Collectors.toList()))
                .stream()
                .map(value -> modelMapper.map(value, Customer.class))
                .collect(Collectors.toList());
    }

    @Override
    public Customer getById(String id) {

        Optional<CustomerEntity> entity = customerRepository.findById(id);

        return entity.map(customerEntity -> modelMapper.map(customerEntity, Customer.class)).orElse(null);

    }

    @Override
    public List<Customer> getByParams(Map<String, String> params) {
        return customerRepository
                .findAll()
                .stream()
                .map(value -> modelMapper.map(value, Customer.class))
                .collect(Collectors.toList());
    }
}
