package com.pruebatecnica.backendservice.dtos;

import lombok.Data;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

@Data
@Configuration
public class Entity {

    @Value("{entity.value}")
    private String id ;





}
