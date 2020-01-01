package com.studiojms.microservice.provider.controller;

import com.studiojms.microservice.provider.model.Product;
import com.studiojms.microservice.provider.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author studiojms
 */
@RestController
@RequestMapping("/product")
public class ProductController {

    @Autowired
    private ProductService productService;

    @RequestMapping("/{state}")
    public List<Product> getProductsByState(@PathVariable("state") String state) {
        return productService.getProductsByState(state);
    }
}
