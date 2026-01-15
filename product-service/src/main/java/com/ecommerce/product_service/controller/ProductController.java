package com.ecommerce.product_service.controller;

import com.ecommerce.product_service.model.Product;
import com.ecommerce.product_service.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/product")
public class ProductController {

    @Autowired
    private ProductService productService;

    @PostMapping("/add")
    public ResponseEntity add(@RequestBody Product product){
        return productService.addproduct(product);
    }

    @GetMapping("/all/{id}")
    public Product getById(@PathVariable Long id) {
        return productService.getById(id);
    }


}
