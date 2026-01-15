package com.ecommerce.product_service.service;

import com.ecommerce.product_service.model.Product;
import com.ecommerce.product_service.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;


@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;


    public ResponseEntity addproduct(Product product){
        productRepository.save(product);
        return ResponseEntity.ok("Product Added Successfully..");
    }

    public List<Product> get() {
        List<Product> products = productRepository.findAll();
        products.forEach(p -> System.out.println(p));
        return products;
    }
    public Product getById(Long id) {
        return productRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Product not found"));
    }

}
