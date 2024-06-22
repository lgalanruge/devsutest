package com.pruebatecnica.backendservice.dtos;

import com.pruebatecnica.backendservice.utils.Genere;
import lombok.Data;

@Data
public class Person {

    private String id ;

    private String name ;

    private  Integer age ;

    private Long identificationNumber ;

    private String address ;

    private String phoneNumber ;

    private Genere genere ;




}
