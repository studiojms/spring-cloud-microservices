package com.studiojms.microservice.store.to;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

/**
 * @author studiojms
 */
@Getter
@Setter
@NoArgsConstructor
public class DeliveryInfoTO {
    private Long orderId;
    private LocalDate deliveryDate;
    private String sourceAddress;
    private String destinationAddress;

}
