package com.huydevtr.demo.controllers.restControllers;

import com.huydevtr.demo.models.DTO.ProductMapper;
import com.huydevtr.demo.models.DTO.UserMapper;
import com.huydevtr.demo.models.DTOentities.ProductGetDTO;
import com.huydevtr.demo.models.DTOentities.RatingSlimDTO;
import com.huydevtr.demo.models.entities.Product;
import com.huydevtr.demo.models.entities.Rating;
import com.huydevtr.demo.models.entitiesLink.Product_Category;
import com.huydevtr.demo.repositories.RatingRepository;
import com.huydevtr.demo.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping(path = "rest-product")
public class ProductRestController {
    @Autowired
    private ProductService productService;
    @Autowired
    private ProductMapper productMapper;
    @Autowired
    RatingRepository ratingRepository;
    @Autowired
    private UserMapper userMapper;
    @GetMapping("/rating/{id}")
    public ResponseEntity<List<RatingSlimDTO>> getAllRating(
            @PathVariable(value = "id") int productId
    ) {
        List<Rating> ratings = ratingRepository.findAllByProductProductId(productId);
        List<RatingSlimDTO> ratingDTOs = ratings.stream()
                .map(userMapper::ratingToRatingDTO)
                .collect(Collectors.toList());

        return new ResponseEntity<>(ratingDTOs, HttpStatus.OK);
    }

    @GetMapping("/product/{id}")
    public ResponseEntity<ProductGetDTO> getById(
            @PathVariable(value = "id") int id
    ) {
        return new ResponseEntity<>(
                productMapper.productToProductGetDTO(
                        productService.findByID(id)
                ),
                HttpStatus.OK
        );
    }
    @GetMapping("/product")
    public ResponseEntity<List<ProductGetDTO>> getAllProducts() {
        List<Product> products = productService.findAll();
        List<ProductGetDTO> productDTOs = products.stream()
                .map(productMapper::productToProductGetDTO)
                .collect(Collectors.toList());

        return new ResponseEntity<>(productDTOs, HttpStatus.OK);
    }
    @GetMapping("/product-limit")
    public ResponseEntity<List<ProductGetDTO>> getAllP(
            @RequestParam int page,
            @RequestParam int limit
    ) {
        Page<Product> products = productService.findAllOrderBySNumber(page, limit);
        List<ProductGetDTO> productDTOs = products.stream()
                .map(productMapper::productToProductGetDTO)
                .collect(Collectors.toList());

        return new ResponseEntity<>(productDTOs, HttpStatus.OK);
    }
    @GetMapping("/category")
    public ResponseEntity<List<Product_Category>> listResponseEntity (
            @RequestParam String category
    ) {
        List<Product_Category> productCategories = productService.findAllProductByCategory(category);

        return new ResponseEntity<>(productCategories, HttpStatus.OK);
    }
}
