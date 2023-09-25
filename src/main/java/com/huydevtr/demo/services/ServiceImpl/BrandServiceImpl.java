package com.huydevtr.demo.services.ServiceImpl;

import com.huydevtr.demo.models.entities.Brand;
import com.huydevtr.demo.repositories.BrandRepository;
import com.huydevtr.demo.services.BrandService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BrandServiceImpl implements BrandService {
    private BrandRepository brandRepository;
    @Autowired
    public BrandServiceImpl(BrandRepository theProductRepository) {
        brandRepository = theProductRepository;
    }
    @Override
    public List<Brand> listBrand() {
        return brandRepository.findAll();
    }

    @Override
    public Brand getBrandsById(int brandId) {
        return brandRepository.findBrandByBrandId(brandId);
    }
    @Override

    public Brand getBrandsByBrandName(String brandId) {
        return brandRepository.getByBrandName(brandId);
    }
}
