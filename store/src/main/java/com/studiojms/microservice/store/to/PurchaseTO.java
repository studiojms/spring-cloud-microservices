package com.studiojms.microservice.store.to;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

/**
 * @author studiojms
 */
@Getter
@Setter
public class PurchaseTO {
    @JsonIgnore
    private Long purchaseId;
    private List<PurchaseItemTO> items;
    private AddressTO address;
}
