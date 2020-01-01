package com.studiojms.microservice.store.to;

import lombok.Getter;
import org.springframework.stereotype.Service;

/**
 * @author studiojms
 */
@Getter
@Service
public class ProviderInfoTO {
    private String address;
    private String state;
}
