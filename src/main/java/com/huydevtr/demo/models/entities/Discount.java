package com.huydevtr.demo.models.entities;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name = "discount")
public class Discount {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "discountId")
    int discountId;
    @OneToOne
    @MapsId("productId")
    @JoinColumn(name = "productId")
    Product product;
    @Column(name = "value")
    double value;
    @Column(name = "startDay")
    String startDay;
    @Column(name = "endDay")
    String endDay;
}
