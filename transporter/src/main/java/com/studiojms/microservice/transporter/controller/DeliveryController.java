package com.studiojms.microservice.transporter.controller;

import com.studiojms.microservice.transporter.service.DeliveryService;
import com.studiojms.microservice.transporter.to.DeliveryTO;
import com.studiojms.microservice.transporter.to.VoucherTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author studiojms
 */
@RestController
@RequestMapping("/delivery")
public class DeliveryController {
    @Autowired
    private DeliveryService deliveryService;

    @RequestMapping(method = RequestMethod.POST)
    public VoucherTO bookReservation(@RequestBody DeliveryTO deliveryTO) {
        return deliveryService.bookDelivery(deliveryTO);
    }
}
