package com.studiojms.microservice.store.to;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

/**
 * @author studiojms
 */
@Getter
@Setter
public class VoucherTO {
    private Long number;
    private LocalDate deliveryForecast;

}
