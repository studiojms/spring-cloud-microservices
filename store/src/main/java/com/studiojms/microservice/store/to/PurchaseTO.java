package com.studiojms.microservice.store.to;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

/**
 * @author jefferson.souza
 */
@Getter
@Setter
public class PurchaseTO {
    private List<PurchaseItemTO> items;
    private AddressTO address;
}
