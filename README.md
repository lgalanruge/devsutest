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

 

## Documentacion

## Documentacion Funcional. 

A continuacion se explica el flujo del microservicio: 

1. Se crean los usuarios 
2. Con base al usuarios creados, se crean las cuentas. 
3. Con base a las cuentas se crea los movimientos. 


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
POST /api/clientes HTTP/1.1
Host: localhost:8086
Content-Type: application/json
Content-Length: 297

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
    }
]


##### Response

[
    {
        "id": "5babdc29-7272-48d6-9e56-10ab22b01885",
        "name": "John Doe",
        "age": 30,
        "identificationNumber": 123456789,
        "address": "123 Main St, Cityville",
        "phoneNumber": "+1234567890",
        "genere": "MALE",
        "customerId": "08af98d0-42c4-4006-a7f0-f9abd7464929",
        "passWord": "password123",
        "status": "ACTIVE"
    }
]

#### /cuentas - Metodo HTTP POST 

##### Request 

POST /api/cuentas HTTP/1.1
Host: localhost:8086
Content-Type: application/json
Content-Length: 416

[
    {
        "accountNumber": 1234567890123456,
        "amount": 2500.75,
        "status": "ACTIVE",
        "type": "AHORROS",
        "customerId": "08af98d0-42c4-4006-a7f0-f9abd7464929"
    },
    {
        "accountNumber": 1122334455667788,
        "amount": 750.30,
        "status": "ACTIVE",
        "type": "CORRIENTE",
        "customerId": "08af98d0-42c4-4006-a7f0-f9abd7464929"
    }
]

##### Response
[
    {
        "accountNumber": 1234567890123456,
        "amount": 2500.75,
        "status": "ACTIVE",
        "id": "4432b536-35c4-4c4c-a306-12ecc3dc83f8",
        "type": "AHORROS",
        "entity": {
            "id": "123456"
        },
        "transactions": null,
        "customerId": "08af98d0-42c4-4006-a7f0-f9abd7464929"
    },
    {
        "accountNumber": 1122334455667788,
        "amount": 750.30,
        "status": "ACTIVE",
        "id": "19271953-a3e9-4f09-836f-2104d84170a0",
        "type": "CORRIENTE",
        "entity": {
            "id": "123456"
        },
        "transactions": null,
        "customerId": "08af98d0-42c4-4006-a7f0-f9abd7464929"
    }
]

#### /movimientos - Metodo HTTP POST 

##### Request 

POST /api/movimientos HTTP/1.1
Host: localhost:8086
Content-Type: application/json
Content-Length: 496

[
    {
        "type": "DEBIT",
        "value": 150.00,
        "amount": 0,
        "accountId": "4432b536-35c4-4c4c-a306-12ecc3dc83f8"
    },
    {
        "date": "2024-06-21T16:00:00Z",
        "type": "DEBIT",
        "value": 300.00,
        "amount": 0,
        "accountId": "4432b536-35c4-4c4c-a306-12ecc3dc83f8"
    },
    {
        "type": "CREDIT",
        "value": 1450.00,
        "amount": 0,
        "accountId": "4432b536-35c4-4c4c-a306-12ecc3dc83f8"
    }
]

##### Response

[
    {
        "id": "a382997b-4e9f-4a91-86e4-f25b7acff8c1",
        "date": "2024-06-24",
        "type": "DEBIT",
        "value": 150.00,
        "amount": 2650.75,
        "accountId": "4432b536-35c4-4c4c-a306-12ecc3dc83f8"
    },
    {
        "id": "1c9fb825-f864-4b3d-9f2c-bea201bb2949",
        "date": "2024-06-21",
        "type": "DEBIT",
        "value": 300.00,
        "amount": 2950.75,
        "accountId": "4432b536-35c4-4c4c-a306-12ecc3dc83f8"
    },
    {
        "id": "f75d9d46-4bb2-4404-a99f-1e18a96a54dd",
        "date": "2024-06-24",
        "type": "CREDIT",
        "value": 1450.00,
        "amount": 1500.75,
        "accountId": "4432b536-35c4-4c4c-a306-12ecc3dc83f8"
    }
]

#### /movimientos - Metodo HTTP GET 

##### Request 
GET /api/cuentas/4432b536-35c4-4c4c-a306-12ecc3dc83f8 HTTP/1.1
Host: localhost:8086

##### Response

{
    "accountNumber": 1234567890123456,
    "amount": 1500.75,
    "status": "ACTIVE",
    "id": "4432b536-35c4-4c4c-a306-12ecc3dc83f8",
    "type": "AHORROS",
    "entity": {
        "id": "123456"
    },
    "transactions": [
        {
            "id": "a382997b-4e9f-4a91-86e4-f25b7acff8c1",
            "date": "2024-06-24",
            "type": "DEBIT",
            "value": 150.00,
            "amount": 2650.75,
            "accountId": "4432b536-35c4-4c4c-a306-12ecc3dc83f8"
        },
        {
            "id": "1c9fb825-f864-4b3d-9f2c-bea201bb2949",
            "date": "2024-06-21",
            "type": "DEBIT",
            "value": 300.00,
            "amount": 2950.75,
            "accountId": "4432b536-35c4-4c4c-a306-12ecc3dc83f8"
        },
        {
            "id": "f75d9d46-4bb2-4404-a99f-1e18a96a54dd",
            "date": "2024-06-24",
            "type": "CREDIT",
            "value": 1450.00,
            "amount": 1500.75,
            "accountId": "4432b536-35c4-4c4c-a306-12ecc3dc83f8"
        }
    ],
    "customerId": "08af98d0-42c4-4006-a7f0-f9abd7464929"
}
