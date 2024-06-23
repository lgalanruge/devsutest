package com.pruebatecnica.backendservice.dtos;

import com.pruebatecnica.backendservice.utils.AccountType;
import com.pruebatecnica.backendservice.utils.Status;
import lombok.Data;

<<<<<<< HEAD
import java.util.List;

=======
>>>>>>> 0b2c909d87938cf082da51547a4e358275d7ae49
@Data
public class Account {


    private  Long accountNumber ;

    private Double amount ;

    private Status status ;

    private String id ;

    private AccountType type ;

    private Entity entity ;

<<<<<<< HEAD
    private List<Transaction> transactions ;


=======
>>>>>>> 0b2c909d87938cf082da51547a4e358275d7ae49
}
