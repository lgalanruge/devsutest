package com.pruebatecnica.backendservice.repositories;

import com.pruebatecnica.backendservice.entities.CustomerEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepository extends JpaRepository<CustomerEntity, String> {

}
