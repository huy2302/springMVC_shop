package com.huydevtr.demo.models.entitiesLink;

import com.huydevtr.demo.models.entities.Category;
import com.huydevtr.demo.models.entities.Product;
import com.huydevtr.demo.models.entities.SubCategory;
import lombok.Data;

import javax.persistence.*;
@Entity
@Data
@Table(name = "product_category")
public class Product_Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @ManyToOne
    @MapsId("productId")
    @JoinColumn(name = "productId")
    Product product;
    @ManyToOne
    @MapsId("categoryId")
    @JoinColumn(name = "categoryId")
    Category category;
    @ManyToOne
    @MapsId("subCategoryId")
    @JoinColumn(name = "subCategoryId")
    SubCategory subCategory;

    public Product_Category() {
    }

    public Product_Category(int id, Product product, Category category, SubCategory subCategory) {
        this.id = id;
        this.product = product;
        this.category = category;
        this.subCategory = subCategory;
    }
}
