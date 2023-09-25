package com.huydevtr.demo.models;

import java.util.List;

public class ProductImageDTO {
    private int idProduct;
    private List<String> imgUrls;

    public ProductImageDTO () {}
    public ProductImageDTO(int idProduct, List<String> imgUrls) {
        this.idProduct = idProduct;
        this.imgUrls = imgUrls;
    }

    public int getIdProduct() {
        return idProduct;
    }

    public void setIdProduct(int idProduct) {
        this.idProduct = idProduct;
    }

    public List<String> getImgUrls() {
        return imgUrls;
    }

    public void setImgUrls(List<String> imgUrls) {
        this.imgUrls = imgUrls;
    }
}
