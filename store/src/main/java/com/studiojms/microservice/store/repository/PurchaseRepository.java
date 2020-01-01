package com.studiojms.microservice.store.repository;

import com.studiojms.microservice.store.model.Purchase;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * @author studiojms
 */
@Repository
public interface PurchaseRepository extends CrudRepository<Purchase, Long> {
}
