package com.huydevtr.demo.models.DTO;

import com.huydevtr.demo.models.DTOentities.*;
import com.huydevtr.demo.models.entities.Brand;
import com.huydevtr.demo.models.entities.Discount;
import com.huydevtr.demo.models.entities.Product;
import com.huydevtr.demo.models.entities.SubCategory;
import com.huydevtr.demo.models.entitiesLink.Product_Category;
import com.huydevtr.demo.models.entitiesLink.Product_brand_origin;
import org.mapstruct.Mapper;

import java.util.ArrayList;
import java.util.List;

@Mapper(
        componentModel = "spring"
)
public interface ProductMapper {
    BrandSlimDTO brandToBrandSlimDTO(Brand brand);
    DiscountSlimDTO discToDiscSlimDTO(Discount discount);
    ProductPostDTO productToProductPostDTO(Product product);
    ProductGetDTO productToProductGetDTO(Product product);
    Brand getBrandsByID(int idBrand);
    ArrayList<String> getImagesByProductId(int productId);
    public ArrayList<String> getClassifyByProductId(int productId, int type);
    List<Product_brand_origin> getProductBOByProductId(int idProduct);
    double priceAfterDiscount(ProductGetDTO productGetDTO);
    List<Product_Category> getProductCategoryByProductId(int productId);
    SubCategory getSubCategoryByID(int idBrand);
    ArrayList<ProductClassifySlimDTO> getProductClassify(int productId);

}
