package com.studiojms.microservice.store.client;

import com.studiojms.microservice.store.to.DeliveryInfoTO;
import com.studiojms.microservice.store.to.VoucherTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @author studiojms
 */
@FeignClient("transporter")
public interface ITransporterClient {

    @RequestMapping(path = "/delivery", method = RequestMethod.POST)
    VoucherTO bookDelivery(DeliveryInfoTO deliveryInfoTO);

}
