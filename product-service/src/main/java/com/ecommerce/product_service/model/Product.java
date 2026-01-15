package com.ecommerce.product_service.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "products")
public class Product {

    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private Double price;
    private Long stock;

    public Long getId() { return id; }
    public String getName() { return name; }
    public Double getPrice() { return price; }
    public Long getStock() { return stock; }
}
