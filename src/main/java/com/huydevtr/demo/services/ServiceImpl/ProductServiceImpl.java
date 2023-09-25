package com.huydevtr.demo.services.ServiceImpl;

import com.huydevtr.demo.models.entities.Product;
import com.huydevtr.demo.models.entitiesLink.Product_Category;
import com.huydevtr.demo.repositories.ProductCategoryRepository;
import com.huydevtr.demo.repositories.ProductRepository;
import com.huydevtr.demo.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import org.springframework.data.domain.Pageable;
import java.util.List;
import java.util.Optional;

@Service
public class ProductServiceImpl implements ProductService {
    private ProductRepository productRepository;
    private ProductCategoryRepository productCategoryRepository;

    @Autowired
    public ProductServiceImpl(
            ProductRepository productRepository,
            ProductCategoryRepository productCategoryRepository
    ) {
        this.productRepository = productRepository;
        this.productCategoryRepository = productCategoryRepository;
    }


    @Override
    public List<Product> findAll() {
        return (List<Product>) productRepository.findAll();
    }
    @Override
    public Product findByID(int id_product) {
        Optional<Product> result = productRepository.findById(id_product);

        Product product = null;

        if (result.isPresent()) {
            product = result.get();
        } else {
            throw new RuntimeException("Did not find product id - " + id_product);
        }

        return product;
    }

    @Override
    public void save(Product product) {

    }

    @Override
    public void deleteByID(int id_product) {

    }

    @Override
    public Page<Product> findAllOrderBySNumber(int page, int limit) {
        Pageable topTwenty = PageRequest.of(page, limit);
        Page<Product> notifications = productRepository.findAll((org.springframework.data.domain.Pageable) topTwenty);
        return notifications;
    }
    @Override
    public List<Product_Category> findAllProductByCategory(String category) {
        List<Product_Category> productCategories = productCategoryRepository.findAllBySubCategorySubCategory(category);
        return productCategories;
    }
}
