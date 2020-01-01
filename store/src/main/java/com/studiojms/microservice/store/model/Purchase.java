package com.studiojms.microservice.store.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;

/**
 * @author studiojms
 */
@Entity
@Getter
@Setter
public class Purchase {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    private PurchaseState state;

    private Long orderId;
    private Integer preparationTime;
    private String destinyAddress;
    private LocalDate deliveryDate;
    private Long voucher;
}
