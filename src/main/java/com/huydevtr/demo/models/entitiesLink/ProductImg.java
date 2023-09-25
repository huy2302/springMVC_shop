package com.huydevtr.demo.models.entitiesLink;

import com.huydevtr.demo.models.entities.Product;

import javax.persistence.*;

@Entity
@Table (name = "productimage")
public class ProductImg {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column (name = "imageId")
    private Integer imageId;

    @ManyToOne
    @MapsId("productId")
    @JoinColumn(name = "productId")
    Product product;

    @Column (name = "imgURL")
    private String imgUrl;

    public ProductImg() {}

    public ProductImg(Integer imageId, Product product, String imgUrl) {
        this.imageId = imageId;
        this.product = product;
        this.imgUrl = imgUrl;
    }

    public Integer getImageId() {
        return imageId;
    }

    public void setImageId(Integer imageId) {
        this.imageId = imageId;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }
}
