package com.huydevtr.demo.models.entitiesLink;

import com.huydevtr.demo.models.entities.Product;
import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name = "product_classify")
public class Product_Classify {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "product_classifyID")
    private int product_classifyID;

    @ManyToOne
    @MapsId("productId")
    @JoinColumn(name = "productId")
    Product product;
    @Column(name = "classificationName1")
    private String classificationName1;
    @Column(name = "classificationName2")
    private String classificationName2;
    @Column(name = "quantity")
    private int quantity;

    public Product_Classify() {
    }

    public Product_Classify(int product_classifyID, Product product, String classificationName1, String classificationName2, int quantity) {
        this.product_classifyID = product_classifyID;
        this.product = product;
        this.classificationName1 = classificationName1;
        this.classificationName2 = classificationName2;
        this.quantity = quantity;
    }
}
