package com.pruebatecnica.backendservice.repositories;

import com.pruebatecnica.backendservice.entities.PersonEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonRepository extends JpaRepository<PersonEntity, String> {

}
