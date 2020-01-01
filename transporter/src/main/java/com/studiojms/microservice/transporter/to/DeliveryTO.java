package com.studiojms.microservice.transporter.to;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

/**
 * @author studiojms
 */
@Getter
@Setter
public class DeliveryTO {
    private Long orderId;
    private LocalDate deliveryDate;
    private String sourceAddress;
    private String destinationAddress;

}
