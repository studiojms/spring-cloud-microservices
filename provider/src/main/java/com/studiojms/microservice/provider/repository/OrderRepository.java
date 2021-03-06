package com.studiojms.microservice.provider.repository;

import com.studiojms.microservice.provider.model.Order;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * @author studiojms
 */
@Repository
public interface OrderRepository extends CrudRepository<Order, Long> {
}
