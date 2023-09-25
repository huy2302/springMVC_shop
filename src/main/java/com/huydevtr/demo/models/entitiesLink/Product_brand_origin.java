package com.huydevtr.demo.models.entitiesLink;

import com.huydevtr.demo.models.entities.Brand;
import com.huydevtr.demo.models.entities.Origin;
import com.huydevtr.demo.models.entities.Product;

import javax.persistence.*;

@Entity
@Table(name = "product_brand_origin")
public class Product_brand_origin {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    @Column (name = "id")
    private int id;

    @ManyToOne
    @MapsId("productId")
    @JoinColumn(name = "productId")
    Product product;

    @ManyToOne
    @MapsId("brandId")
    @JoinColumn(name = "brandId")
    Brand brand;

    @ManyToOne
    @MapsId("originId")
    @JoinColumn(name = "originId")
    Origin origin;

    public Brand getBrand() {
        return brand;
    }

    public void setBrand(Brand brand) {
        this.brand = brand;
    }

    public Origin getOrigin() {
        return origin;
    }

    public void setOrigin(Origin origin) {
        this.origin = origin;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public Product_brand_origin() {}

    public Product_brand_origin(int id, Product product, Brand brand, Origin origin) {
        this.id = id;
        this.product = product;
        this.brand = brand;
        this.origin = origin;
//        this.productId = productId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
