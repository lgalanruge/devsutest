package com.pruebatecnica.backendservice.dtos;

import lombok.Data;
<<<<<<< HEAD
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

@Data
@Configuration
public class Entity {

    @Value("{entity.value}")
    private String id ;




=======

@Data
public class Entity {

    private String id ;

>>>>>>> 0b2c909d87938cf082da51547a4e358275d7ae49
}
