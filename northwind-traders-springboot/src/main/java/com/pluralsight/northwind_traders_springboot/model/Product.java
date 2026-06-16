package com.pluralsight.northwind_traders_springboot.model;

import jakarta.persistence.*;

@Entity
@Table(name = "Products")
public class Product {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "`ProductID`")
    private Long productId;

    @Column(name = "`ProductName`")
    private String name;

    @Column(name = "`CategoryID`")
    private int category;
    @Column(name = "`UnitPrice`")
    private double price;


    public Product() {};

    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCategory() {
        return category;
    }

    public void setCategory(int category) {
        this.category = category;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
