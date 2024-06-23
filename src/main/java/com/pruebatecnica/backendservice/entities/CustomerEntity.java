package com.pruebatecnica.backendservice.entities;

import com.pruebatecnica.backendservice.utils.Status;
import jakarta.persistence.*;
import lombok.Data;

<<<<<<< HEAD
import java.util.List;

=======
>>>>>>> 0b2c909d87938cf082da51547a4e358275d7ae49
@Data
@Entity
@Table(name = "customer")
public class CustomerEntity  {

    @Id
    private String customerId ;

    @Column(name = "password", nullable = false)
    private  String passWord ;

    @Column(name = "status")
    private Status status ;


    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "person_id", referencedColumnName = "id")
    private PersonEntity personId ;

<<<<<<< HEAD
    @OneToMany(mappedBy = "customerId")
    private List<AccountEntity> accounts ;
=======
>>>>>>> 0b2c909d87938cf082da51547a4e358275d7ae49


}
