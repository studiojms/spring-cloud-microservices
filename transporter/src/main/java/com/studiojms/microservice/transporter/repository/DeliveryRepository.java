package com.studiojms.microservice.transporter.repository;

import com.studiojms.microservice.transporter.model.Delivery;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * @author studiojms
 */
@Repository
public interface DeliveryRepository extends CrudRepository<Delivery, Long> {
}
