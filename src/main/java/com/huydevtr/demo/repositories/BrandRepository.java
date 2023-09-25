package com.huydevtr.demo.repositories;

import com.huydevtr.demo.models.entities.Brand;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BrandRepository extends JpaRepository<Brand, Integer> {
    public Brand findBrandByBrandId(int brandId);
    public Brand getByBrandName(String brandName);

}