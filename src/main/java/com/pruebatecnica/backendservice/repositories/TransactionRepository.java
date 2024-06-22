package com.pruebatecnica.backendservice.repositories;

import com.pruebatecnica.backendservice.entities.TransactionEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TransactionRepository extends JpaRepository<TransactionEntity, String> {
}
