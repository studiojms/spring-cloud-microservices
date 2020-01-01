package com.studiojms.microservice.provider.service;

import com.studiojms.microservice.provider.model.Product;
import com.studiojms.microservice.provider.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author studiojms
 */
@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    public List<Product> getProductsByState(String state) {
        return productRepository.findByState(state);
    }
}
