package com.studiojms.microservice.store.model;

import lombok.Getter;
import lombok.Setter;

/**
 * @author jefferson.souza
 */
@Getter
@Setter
public class Purchase {
    private Long orderId;
    private Integer preparationTime;
    private String destinyAddress;
}
