package com.huydevtr.demo.models.entities;


import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name = "product")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "productId")
    private int productId;

    @Column(name = "productName")
    private String productName;

    @Column(name = "description")
    private String description;

    @Column(name = "totalRate")
    private int totalRate;

    @Column(name = "ratings")
    private double ratings;

    @Column(name = "price")
    private double price;
    @Column(name = "classification1")
    private String classification1;
    @Column(name = "classification2")
    private String classification2;

    public Product() {}

    public Product(int productId, String productName, String description, int totalRate, double ratings, double price, String classification1, String classification2) {
        this.productId = productId;
        this.productName = productName;
        this.description = description;
        this.totalRate = totalRate;
        this.ratings = ratings;
        this.price = price;
        this.classification1 = classification1;
        this.classification2 = classification2;
    }
}

