package com.huydevtr.demo.models.entities;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name = "rating")
public class Rating {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ratingId")
    private Integer ratingId;
    @ManyToOne
    @MapsId("productId")
    @JoinColumn(name = "productId")
    Product product;
    @ManyToOne
    @MapsId("userId")
    @JoinColumn(name = "userId")
    User user;
    @Column(name = "rating")
    private double rating;
    @Column(name = "description")
    private String description;

    public Rating() {
    }

    public Rating(Integer ratingId, Product product, User user, double rating, String description) {
        this.ratingId = ratingId;
        this.product = product;
        this.user = user;
        this.rating = rating;
        this.description = description;
    }
}
