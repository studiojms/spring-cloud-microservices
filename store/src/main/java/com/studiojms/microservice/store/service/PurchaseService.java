package com.studiojms.microservice.store.service;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.studiojms.microservice.store.client.IProviderClient;
import com.studiojms.microservice.store.client.ITransporterClient;
import com.studiojms.microservice.store.model.Purchase;
import com.studiojms.microservice.store.model.PurchaseState;
import com.studiojms.microservice.store.repository.PurchaseRepository;
import com.studiojms.microservice.store.to.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

/**
 * @author studiojms
 */
@Service
public class PurchaseService {

    @Autowired
    private IProviderClient providerClient;

    @Autowired
    private ITransporterClient transporterClient;

    @Autowired
    private PurchaseRepository purchaseRepository;

    private static final Logger LOGGER = LoggerFactory.getLogger(PurchaseService.class);

    @HystrixCommand(fallbackMethod = "createPurchaseFallback", threadPoolKey = "createPurchaseThreadPool")
    public Purchase createPurchase(PurchaseTO purchaseTO) {
        final Purchase purchase = new Purchase();
        purchase.setDestinyAddress(purchaseTO.getAddress().toString());
        purchase.setState(PurchaseState.RECEIVED);
        purchaseRepository.save(purchase);

        purchaseTO.setPurchaseId(purchase.getId());

        final String state = purchaseTO.getAddress().getState();
        LOGGER.info("Looking up for provider information from {}", state);

        final ProviderInfoTO providerInfoTO = providerClient.getInfoByState(state);

        LOGGER.info("Making an order");
        final OrderInfoTO order = providerClient.createOrder(purchaseTO.getItems());

        purchase.setOrderId(order.getId());
        purchase.setPreparationTime(order.getPreparationTime());
        purchase.setState(PurchaseState.ORDER_CREATED);
        purchaseRepository.save(purchase);


        DeliveryInfoTO deliveryInfoTO = new DeliveryInfoTO();
        deliveryInfoTO.setOrderId(order.getId());
        deliveryInfoTO.setDeliveryDate(LocalDate.now().plusDays(order.getPreparationTime()));
        deliveryInfoTO.setSourceAddress(providerInfoTO.getAddress());
        deliveryInfoTO.setDestinationAddress(purchaseTO.getAddress().toString());

        VoucherTO voucherTO = transporterClient.bookDelivery(deliveryInfoTO);


        purchase.setDeliveryDate(deliveryInfoTO.getDeliveryDate());
        purchase.setVoucher(voucherTO.getNumber());

        purchase.setState(PurchaseState.DELIVERY_BOOKED);
        purchaseRepository.save(purchase);

        return purchase;
    }

    @HystrixCommand(threadPoolKey = "getByIdThreadPool")
    public Purchase getById(Long id) {
        return purchaseRepository.findById(id).orElse(null);
    }

    public Purchase createPurchaseFallback(PurchaseTO purchaseTO) {
        Purchase purchase = new Purchase();

        if (purchaseTO.getPurchaseId() != null) {
            purchase = purchaseRepository.findById(purchaseTO.getPurchaseId()).orElse(null);
        } else {
            purchase.setDestinyAddress(purchaseTO.getAddress().toString());
        }

        return purchase;
    }

}
