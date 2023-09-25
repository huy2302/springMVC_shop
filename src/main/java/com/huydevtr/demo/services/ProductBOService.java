package com.huydevtr.demo.services;

import com.huydevtr.demo.models.entitiesLink.Product_brand_origin;

import java.util.List;

public interface ProductBOService {
    public List<Product_brand_origin> findAll();

    public List<Product_brand_origin> getDetailsByIdProduct(int idProduct);

}
