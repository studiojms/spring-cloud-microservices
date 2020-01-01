Each project represents a microservice.

### api-gateway

Represents the gateway whose main responsibility is to communicate with the other services

### config-server

Represents a configuration service

### eureka-server

Represents a service discovery service

### provider

Represents an API that stores data from providers (for product providing)

### transporter

Represents an API that stores data from transporters (for product delivery)

### store

Represents a store service that consumes data from the provider and creates orders

### oauth-server

Represents an authentication server


All config data are stored in [https://github.com/studiojms/spring-cloud-microservice-data](https://github.com/studiojms/spring-cloud-microservice-data)
