package com.huydevtr.demo.repositories;

import com.huydevtr.demo.models.entities.SubCategory;
import com.huydevtr.demo.models.entitiesLink.Product_Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface ProductCategoryRepository extends JpaRepository<Product_Category, Integer> {
    List<Product_Category> findAllByProductProductId(int productId);
    List<Product_Category> findAllBySubCategorySubCategory(String subCategory);

}
