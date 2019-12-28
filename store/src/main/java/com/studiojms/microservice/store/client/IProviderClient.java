package com.studiojms.microservice.store.client;

import com.studiojms.microservice.store.to.OrderInfoTO;
import com.studiojms.microservice.store.to.ProviderInfoTO;
import com.studiojms.microservice.store.to.PurchaseItemTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

/**
 * @author jefferson.souza
 */
@FeignClient("provider")
public interface IProviderClient {

    @RequestMapping("/info/{state}")
    ProviderInfoTO getInfoByState(@PathVariable String state);

    @RequestMapping(method = RequestMethod.POST, value = "/order")
    OrderInfoTO createOrder(List<PurchaseItemTO> items);
}
