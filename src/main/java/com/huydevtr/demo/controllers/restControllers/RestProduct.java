package com.huydevtr.demo.controllers.restControllers;

//import com.huydevtr.demo.models.DTO.ProductConverter;
//import com.huydevtr.demo.models.DTO.ProductDTO;
import com.huydevtr.demo.models.DTO.ProductMapper;
import com.huydevtr.demo.models.DTO.UserMapper;
import com.huydevtr.demo.models.DTOentities.ProductGetDTO;
import com.huydevtr.demo.models.DTOentities.RatingSlimDTO;
import com.huydevtr.demo.models.entities.Rating;
import com.huydevtr.demo.models.entitiesLink.ProductImg;
import com.huydevtr.demo.models.entities.Brand;
import com.huydevtr.demo.models.entities.Product;
import com.huydevtr.demo.models.entitiesLink.Product_Classify;
import com.huydevtr.demo.models.entitiesLink.Product_brand_origin;
import com.huydevtr.demo.repositories.ProductBrandOriginRepository;
import com.huydevtr.demo.repositories.ProductCategoryRepository;
import com.huydevtr.demo.repositories.RatingRepository;
import com.huydevtr.demo.services.BrandService;
import com.huydevtr.demo.services.ProductBOService;
import com.huydevtr.demo.services.ProductImgService;
import com.huydevtr.demo.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping(path = "rest")
public class RestProduct {
    @Autowired
    private ProductService productService;
    @Autowired
    private BrandService brandService;
    @Autowired
    private ProductImgService productImgService;
    @Autowired
    private ProductBOService productBOService;
    ProductCategoryRepository productCategoryRepository;
    ProductBrandOriginRepository productBrandOriginRepository;


    @RequestMapping(value = "brand", method = RequestMethod.GET)
    public List<Product_brand_origin> getProduct_brand_origin() {
        List<Product_brand_origin> brands = productBrandOriginRepository.findAll();
        return brands;
    }
    @GetMapping("/api/brand/{idBrand}")
    public ResponseEntity<Brand> getBrandsByBrandName(@PathVariable int idBrand) {
        Brand brands = brandService.getBrandsById(idBrand);
        return ResponseEntity.ok(brands);
    }
    @GetMapping("/dto/brand/{idBrand}")
    public Brand getBrandsBy(@PathVariable int idBrand) {
        Brand brands = brandService.getBrandsById(idBrand);
        return brands;
    }

    @RequestMapping(value = "product-details", method = RequestMethod.GET)
    public List<Product_brand_origin> getProductBrand() {
        List<Product_brand_origin> imgs = productBOService.findAll();
        return imgs;
    }

    @GetMapping("/dto/product/{idProduct}")
    public ResponseEntity<List<Product_brand_origin>> getProductById(@PathVariable int idProduct) {
        List<Product_brand_origin> product = productBOService.getDetailsByIdProduct(idProduct);
        return ResponseEntity.ok(product);
    }

    @GetMapping("/api/product-images/{productId}")
    public ResponseEntity<List<ProductImg>> getProductImagesByProductId(@PathVariable int productId) {
        List<ProductImg> productImageDTO = productImgService.getProductsImagesByProductId(productId);
        return ResponseEntity.ok(productImageDTO);
    }
    @GetMapping("/api/product-images-by-url")
    public ResponseEntity<List<ProductImg>> getProductImagesByImgUrl(@RequestParam String imgUrl) {
        List<ProductImg> productImages = productImgService.getProductImagesByImgUrl(imgUrl);
        return ResponseEntity.ok(productImages);
    }

}
