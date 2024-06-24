package com.pruebatecnica.backendservice.dtos;

import lombok.Data;

import lombok.Getter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;


@Component
public class Entity {

    // @Value("{entity.value}")

    private String ID = "123456";

    public String getID() {
        return ID;
    }
}
