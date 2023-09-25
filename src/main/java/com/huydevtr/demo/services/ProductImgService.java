package com.huydevtr.demo.services;

import com.huydevtr.demo.models.ProductImageDTO;
import com.huydevtr.demo.models.entitiesLink.ProductImg;

import java.util.ArrayList;
import java.util.List;

public interface ProductImgService {
    public List<ProductImg> listImg();
    public List<ProductImg> getProductsImagesByProductId(int productId);
    public ArrayList<String> getImagesByProductId(int productId);
    public List<ProductImg> getProductImagesByImgUrl(String imgUrl);

}
