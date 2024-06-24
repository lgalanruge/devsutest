package com.pruebatecnica.backendservice.services.impl;

import com.pruebatecnica.backendservice.dtos.Entity;
import com.pruebatecnica.backendservice.entities.EntityEntity;
import com.pruebatecnica.backendservice.repositories.EntityRepository;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class EntityService {

    @Autowired
    private EntityRepository repository ;

    @Getter
    private final Entity dto = new Entity() ;

    private static EntityEntity entity ;

    private final ModelMapper modelMapper = new ModelMapper();

    public EntityEntity getEntity() {

        if(entity == null){
            entity = new EntityEntity();
            entity = modelMapper.map(dto, EntityEntity.class);
            repository.save(entity);
        }

        return entity;
    }

}
