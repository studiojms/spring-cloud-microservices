package com.studiojms.microservice.provider.repository;

import com.studiojms.microservice.provider.model.Product;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author jefferson.souza
 */
@Repository
public interface ProductRepository extends CrudRepository<Product, Long> {
    List<Product> findByState(String state);

    List<Product> findByIdIn(List<Long> ids);

}
