package com.studiojms.microservice.provider.controller;

import com.studiojms.microservice.provider.model.Order;
import com.studiojms.microservice.provider.service.OrderService;
import com.studiojms.microservice.provider.to.OrderItemTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author jefferson.souza
 */
@RestController
@RequestMapping("/order")
public class OrderController {

    private static final Logger LOGGER = LoggerFactory.getLogger(OrderController.class);

    @Autowired
    private OrderService orderService;

    @RequestMapping(method = RequestMethod.POST)
    public Order createOrder(@RequestBody List<OrderItemTO> items) {
        LOGGER.info("Order received");

        return orderService.createOrder(items);
    }

    @RequestMapping("/{id}")
    public Order getOrderById(@PathVariable Long id) {
        return orderService.getOrderById(id);
    }
}
