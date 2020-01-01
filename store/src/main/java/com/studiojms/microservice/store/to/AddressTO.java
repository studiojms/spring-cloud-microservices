package com.studiojms.microservice.store.to;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * @author studiojms
 */
@Getter
@Setter
@ToString(includeFieldNames = false)
public class AddressTO {
    private String street;
    private String number;
    private String city;
    private String state;
    private String postalCode;
}
