package com.studiojms.microservice.transporter.service;

import com.studiojms.microservice.transporter.model.Delivery;
import com.studiojms.microservice.transporter.repository.DeliveryRepository;
import com.studiojms.microservice.transporter.to.DeliveryTO;
import com.studiojms.microservice.transporter.to.VoucherTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author studiojms
 */
@Service
public class DeliveryService {

    @Autowired
    private DeliveryRepository deliveryRepository;

    public VoucherTO bookDelivery(DeliveryTO deliveryTO) {
        final Delivery delivery = new Delivery();
        delivery.setPickupDate(deliveryTO.getDeliveryDate());
        delivery.setDeliveryForecast(deliveryTO.getDeliveryDate().plusDays(1));
        delivery.setDestinationAddress(deliveryTO.getDestinationAddress());
        delivery.setSourceAddress(deliveryTO.getSourceAddress());

        deliveryRepository.save(delivery);

        final VoucherTO voucherTO = new VoucherTO();
        voucherTO.setNumber(delivery.getId());
        voucherTO.setDeliveryForecast(delivery.getDeliveryForecast());

        return voucherTO;
    }
}
