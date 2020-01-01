package com.studiojms.microservice.provider.service;

import com.studiojms.microservice.provider.model.Order;
import com.studiojms.microservice.provider.model.OrderItem;
import com.studiojms.microservice.provider.model.Product;
import com.studiojms.microservice.provider.repository.OrderRepository;
import com.studiojms.microservice.provider.repository.ProductRepository;
import com.studiojms.microservice.provider.to.OrderItemTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @author studiojms
 */
@Service
public class OrderService {

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private ProductRepository productRepository;

    public Order createOrder(List<OrderItemTO> items) {
        if (items == null) {
            return null;
        }

        final List<OrderItem> orderItems = toOrderItem(items);
        final Order order = new Order(orderItems);
        order.setPreparationTime(items.size());
        return orderRepository.save(order);
    }

    public Order getOrderById(Long id) {
        return orderRepository.findById(id).orElse(new Order());
    }

    private List<OrderItem> toOrderItem(List<OrderItemTO> items) {

        List<Long> productIds = items
                .stream()
                .map(OrderItemTO::getId)
                .collect(Collectors.toList());

        List<Product> orderProducts = productRepository.findByIdIn(productIds);

        List<OrderItem> orderItems = items
                .stream()
                .map(item -> {
                    final Product product = orderProducts
                            .stream()
                            .filter(p -> p.getId().equals(item.getId()))
                            .findFirst().get();

                    final OrderItem orderItem = new OrderItem();
                    orderItem.setProduct(product);
                    orderItem.setAmount(item.getAmount());
                    return orderItem;
                })
                .collect(Collectors.toList());
        return orderItems;
    }
}
