package com.studiojms.microservice.provider.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

/**
 * @author studiojms
 */
@Entity
@Getter
@Setter
public class OrderItem {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Integer amount;

    @ManyToOne
    @JoinColumn(name = "productId")
    private Product product;
}
