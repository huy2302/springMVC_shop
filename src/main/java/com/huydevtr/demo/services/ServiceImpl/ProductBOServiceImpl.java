package com.huydevtr.demo.services.ServiceImpl;

import com.huydevtr.demo.models.entitiesLink.Product_brand_origin;
import com.huydevtr.demo.repositories.ProductBrandOriginRepository;
import com.huydevtr.demo.services.ProductBOService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ProductBOServiceImpl implements ProductBOService {

    private final ProductBrandOriginRepository productBrandOriginRepository;
    @Autowired
    public ProductBOServiceImpl(ProductBrandOriginRepository theProductRepository) {
        productBrandOriginRepository = theProductRepository;
    }
    @Override
    public List<Product_brand_origin> findAll() {
        return productBrandOriginRepository.findAll();
    }

    public List<Product_brand_origin> getDetailsByIdProduct(int idProduct) {
        return productBrandOriginRepository.findAllByProductProductId(idProduct);
    }


}
