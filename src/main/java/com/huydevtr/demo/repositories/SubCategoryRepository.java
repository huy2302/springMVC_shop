package com.huydevtr.demo.repositories;

import com.huydevtr.demo.models.entities.Brand;
import com.huydevtr.demo.models.entities.SubCategory;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SubCategoryRepository extends JpaRepository<SubCategory, Integer> {
    public SubCategory findSubCategoryBySubCategoryId(int brandId);
}
