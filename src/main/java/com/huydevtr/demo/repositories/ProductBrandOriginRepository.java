package com.huydevtr.demo.repositories;

import com.huydevtr.demo.models.entitiesLink.Product_brand_origin;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ProductBrandOriginRepository extends JpaRepository<Product_brand_origin, Integer> {
    List<Product_brand_origin> findAllByProductProductId(int productId);
}
