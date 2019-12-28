package com.studiojms.microservice.store.service;

import com.studiojms.microservice.store.client.IProviderClient;
import com.studiojms.microservice.store.model.Purchase;
import com.studiojms.microservice.store.to.OrderInfoTO;
import com.studiojms.microservice.store.to.ProviderInfoTO;
import com.studiojms.microservice.store.to.PurchaseTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author jefferson.souza
 */
@Service
public class PurchaseService {

    @Autowired
    private IProviderClient providerClient;

    private static final Logger LOGGER = LoggerFactory.getLogger(PurchaseService.class);

    public Purchase createPurchase(PurchaseTO purchaseTO) {
        final String state = purchaseTO.getAddress().getState();

        LOGGER.info("Looking up for provider information from {}", state);

        final ProviderInfoTO providerInfoTO = providerClient.getInfoByState(state);

        LOGGER.info("Making an order");
        final OrderInfoTO order = providerClient.createOrder(purchaseTO.getItems());

        final Purchase purchase = new Purchase();
        purchase.setOrderId(order.getId());
        purchase.setPreparationTime(order.getPreparationTime());
        purchase.setDestinyAddress(purchaseTO.getAddress().toString());

        return purchase;
    }
}
