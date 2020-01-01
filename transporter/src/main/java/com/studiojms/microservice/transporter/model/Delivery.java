package com.studiojms.microservice.transporter.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.LocalDate;

/**
 * @author studiojms
 */
@Entity
@Getter
@Setter
public class Delivery {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long orderId;
    private LocalDate pickupDate;
    private LocalDate deliveryForecast;
    private String sourceAddress;
    private String destinationAddress;
}
