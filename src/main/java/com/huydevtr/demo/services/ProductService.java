package com.huydevtr.demo.services;

import com.huydevtr.demo.models.entities.Product;
import com.huydevtr.demo.models.entitiesLink.Product_Category;
import org.springframework.data.domain.Page;

import java.awt.print.Pageable;
import java.util.List;

public interface ProductService {
    public List<Product> findAll();

    public Product findByID(int id_product);

    public void save(Product product);

    public void deleteByID(int id_product);
    public Page<Product> findAllOrderBySNumber(int page, int limit);
    public List<Product_Category> findAllProductByCategory(String category);

}
