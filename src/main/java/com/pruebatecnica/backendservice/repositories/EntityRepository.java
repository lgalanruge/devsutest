package com.pruebatecnica.backendservice.repositories;

import com.pruebatecnica.backendservice.entities.EntityEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EntityRepository extends JpaRepository<EntityEntity, String> {


}
