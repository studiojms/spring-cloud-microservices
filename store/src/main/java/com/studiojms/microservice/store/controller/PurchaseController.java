package com.studiojms.microservice.store.controller;

import com.studiojms.microservice.store.model.Purchase;
import com.studiojms.microservice.store.to.PurchaseTO;
import com.studiojms.microservice.store.service.PurchaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @author studiojms
 */
@RestController
@RequestMapping("/purchase")
public class PurchaseController {

    @Autowired
    private PurchaseService purchaseService;

    @RequestMapping("/{id}")
    public Purchase findById(@PathVariable("id") Long id) {
        return purchaseService.getById(id);
    }

    @RequestMapping(method = RequestMethod.POST)
    public Purchase create(@RequestBody PurchaseTO purchaseTO) {
        return purchaseService.createPurchase(purchaseTO);
    }
}
