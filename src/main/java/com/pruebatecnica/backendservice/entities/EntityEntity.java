package com.pruebatecnica.backendservice.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "entity")
public class EntityEntity {

    @Id
    private String id ;

}
