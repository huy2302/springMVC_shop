package com.huydevtr.demo.repositories;

import com.huydevtr.demo.models.entitiesLink.Product_Classify;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface ProductClassifyRepository extends JpaRepository<Product_Classify, Integer> {
    public List<Product_Classify> findAllByProductProductId(int productId);
}
