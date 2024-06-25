# Prueba tecnica DEVSU 

## Base de datos 

Se utilizo una base de datos en memoria. En esto H2. Los schemas son cargados usando JPA. 
Los datos son creados en tiempo de ejecucion. 

## Postman. 

La URL de los servicios queda en: 

http://localhost:8086/api/

La documentacion de los servicios: 

https://documenter.getpostman.com/view/3792500/2sA3XY7J1p


## Karate

No se implemento. 

## Repositorio en Github 

https://github.com/lgalanruge/devsutest.git

## Despliegue en DOCKER 

Para desplegar en DOCKER 

1. Ejecutar la siguiente sentencia de construccion. 

docker build --no-cache -t backendservices-v1-0 .

2. Ejecutar la siguiente sentencia para iniciar la imagen 

docker run -p 8086:8086 backendservices-v1-0

## Prueba Unitaria 

Se implementa 1 prueba unitaria sobre el servicio de creacion de transacciones. Para esto, se utilizo JUNIT 5 y MOckito. 


## Documentacion tecnica

### Documentacion tecnica 

Se implemento una aplicacion restful en spring-boot. 

Contiene 6 capas: 

1. Controladores: Clases java que exponen servicios REST. Para la aplicacion que implementaron los controladores Customer(Cliente), Account(Cuentas), Transactions(Movimientos). 

2. Casos de uso: Clases inyectadas al controlador que ejecutan los procesos de creacion, actualizacion y lectura de dominios. 

3. Servicios: Clases inyectas a los casos de uso que gestionan la logica de consulta y persistencia a la base de datos. 

4. Repositorio: interfaces que extiendes de JPARepository para consultar y guardar los registros a la base de datos. 

5. Entidades: Clases java que serializan las tablas de la base de datos. 

6. DTOs: Clases java que envian la informacion entre todas las capas. 

### Request/Response

#### /clientes - Metodo HTTP POST 

##### Request 
[
    {        
        "passWord": "password123",
        "status": "ACTIVE",
        "name": "John Doe",
        "age": 30,
        "identificationNumber": 123456789,
        "address": "123 Main St, Cityville",
        "phoneNumber": "+1234567890",
        "genere": "MALE"
    },
    {       
        "passWord": "password456",
        "status": "ACTIVE",
        "name": "Jane Smith",
        "age": 25,
        "identificationNumber": 987654321,
        "address": "456 Another St, Townsville",
        "phoneNumber": "+0987654321",
        "genere": "FEMALE"
    },
    {       
        "passWord": "password789",
        "status": "ACTIVE",
        "name": "Alice Johnson",
        "age": 28,
        "identificationNumber": 112233445,
        "address": "789 Third St, Villagetown",
        "phoneNumber": "+1122334455",
        "genere": "FEMALE"
    }
]

##### Response

#### /cuentas - Metodo HTTP POST 

##### Request 

[
    {
        "accountNumber": 1234567890123456,
        "amount": 2500.75,
        "status": "ACTIVE",
        "type": "AHORROS",
        "customerId": "839e7cbb-7228-4bda-8bc8-76acc2a42ddf"
    },
    {
        "accountNumber": 9876543210987654,
        "amount": 500.00,
        "status": "INACTIVE",
        "type": "CORRIENTE",
        "customerId": "839e7cbb-7228-4bda-8bc8-76acc2a42ddf"
    },
    {
        "accountNumber": 1122334455667788,
        "amount": 750.30,
        "status": "ACTIVE",
        "type": "AHORROS",
        "customerId": "839e7cbb-7228-4bda-8bc8-76acc2a42ddf"
    }
]

##### Response

#### /movimientos - Metodo HTTP POST 

##### Request 

[
    {
        "type": "DEBIT",
        "value": 150.00,
        "amount": 0,
        "accountId": "4acc7368-1918-44b0-92df-fcfa2e48e98f"
    },
    {
        "date": "2024-06-21T16:00:00Z",
        "type": "DEBIT",
        "value": 300.00,
        "amount": 0,
        "accountId": "4acc7368-1918-44b0-92df-fcfa2e48e98f"
    },
    {
        "type": "CREDIT",
        "value": 1450.00,
        "amount": 0,
        "accountId": "4acc7368-1918-44b0-92df-fcfa2e48e98f"
    }
]

##### Response