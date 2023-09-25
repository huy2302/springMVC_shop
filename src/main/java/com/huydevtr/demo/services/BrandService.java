package com.huydevtr.demo.services;

import com.huydevtr.demo.models.entities.Brand;

import java.util.List;

public interface BrandService {
    public List<Brand> listBrand();
    public Brand getBrandsById(int brandId);

    public Brand getBrandsByBrandName(String brandName);
}
