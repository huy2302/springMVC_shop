package com.huydevtr.demo.models.DTO;

import com.huydevtr.demo.models.DTOentities.*;
import com.huydevtr.demo.models.entities.Brand;
import com.huydevtr.demo.models.entities.Discount;
import com.huydevtr.demo.models.entities.Product;
import com.huydevtr.demo.models.entities.SubCategory;
import com.huydevtr.demo.models.entitiesLink.ProductImg;
import com.huydevtr.demo.models.entitiesLink.Product_Category;
import com.huydevtr.demo.models.entitiesLink.Product_Classify;
import com.huydevtr.demo.models.entitiesLink.Product_brand_origin;
import com.huydevtr.demo.repositories.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.processing.Generated;
import java.util.*;

@Generated(
        value = "org.mapstruct.ap.MappingProcessor",
        date = "2021-03-11T19:21:44+0100",
        comments = "version: 1.4.2.Final, compiler: javac, environment: Java 13.0.2 (Oracle Corporation)"
)
@Service
public class ProductMapperImpl implements ProductMapper {
    BrandRepository brandRepository;
    ProductBrandOriginRepository productBrandOriginRepository;
    ProductImgRepository productImgRepository;
    DiscountRepository discountRepository;
    CategoryRepository categoryRepository;
    ProductCategoryRepository productCategoryRepository;
    SubCategoryRepository subCategoryRepository;
    ProductClassifyRepository productClassifyRepository;
    @Autowired
    public ProductMapperImpl(BrandRepository brandRepository,
                             ProductBrandOriginRepository productBrandOriginRepository,
                             ProductImgRepository productImgRepository,
                             DiscountRepository discountRepository,
                             CategoryRepository categoryRepository,
                             ProductCategoryRepository productCategoryRepository,
                             SubCategoryRepository subCategoryRepository,
                             ProductClassifyRepository productClassifyRepository) {
        this.brandRepository = brandRepository;
        this.productBrandOriginRepository = productBrandOriginRepository;
        this.productImgRepository = productImgRepository;
        this.discountRepository = discountRepository;
        this.categoryRepository = categoryRepository;
        this.productCategoryRepository = productCategoryRepository;
        this.subCategoryRepository = subCategoryRepository;
        this.productClassifyRepository = productClassifyRepository;
    }
    @Override
    public BrandSlimDTO brandToBrandSlimDTO(Brand brand) {
        if ( brand == null ) {
            return null;
        }

        BrandSlimDTO bookSlimDto = new BrandSlimDTO(
                brand.getBrandId(),
                brand.getBrandName(),
                brand.getShortBrand()
        );

        return bookSlimDto;
    }

    @Override
    public DiscountSlimDTO discToDiscSlimDTO(Discount discount) {
        if ( discount == null ) {
            return null;
        }

        DiscountSlimDTO discountDTO = new DiscountSlimDTO(
                discount.getDiscountId(),
                discount.getValue(),
                discount.getStartDay(),
                discount.getEndDay()
        );

        return discountDTO;
    }

    @Override
    public ProductPostDTO productToProductPostDTO(Product product) {
        if (product == null) {
            return null;
        }

        ProductPostDTO productPostDTO = new ProductPostDTO();
        productPostDTO.setId(product.getProductId());
        productPostDTO.setProductName(product.getProductName());
        productPostDTO.setDescription(product.getDescription());

        return productPostDTO;
    }
    @Override
    public Brand getBrandsByID(int idBrand) {
        Brand brands = brandRepository.findBrandByBrandId(idBrand);
        return brands;
    }
    @Override
    public SubCategory getSubCategoryByID(int SubCategoryId) {
        SubCategory subCategory = subCategoryRepository.findSubCategoryBySubCategoryId(SubCategoryId);
        return subCategory;
    }
    @Override
    public List<Product_brand_origin> getProductBOByProductId(int productId) {
        List<Product_brand_origin> PBO = productBrandOriginRepository.findAllByProductProductId(productId);
        return PBO;
    }
    @Override
    public List<Product_Category> getProductCategoryByProductId(int productId) {
        List<Product_Category> PC = productCategoryRepository.findAllByProductProductId(productId);
        return PC;
    }
    @Override
    public ArrayList<String> getImagesByProductId(int productId) {
        List<ProductImg> productImgs = productImgRepository.findAllByProductProductId(productId);
        ArrayList<String> images = new ArrayList<>();
        productImgs.forEach(productImg -> {
            images.add(productImg.getImgUrl());
        });
        return images;
    }
    @Override
    public ArrayList<String> getClassifyByProductId(int productId, int type) {
        List<Product_Classify> productImgs = productClassifyRepository.findAllByProductProductId(productId);
        ArrayList<String> classifications = new ArrayList<>();

        if (type == 1) {
            productImgs.forEach(productImg -> {
                classifications.add(productImg.getClassificationName1());
            });
        } else if (type == 2) {
            productImgs.forEach(productImg -> {
                classifications.add(productImg.getClassificationName2());
            });
        }
        Set<String> set = new LinkedHashSet<String>(classifications);
        return new ArrayList<>(set);
    }
    @Override
    public ArrayList<ProductClassifySlimDTO> getProductClassify(int productId) {
        List<Product_Classify> productClassifies = productClassifyRepository.findAllByProductProductId(productId);

        ArrayList<ProductClassifySlimDTO> productClassifySlimDTOS = new ArrayList<>();

// Mảng tránh trùng lặp classification1
        Set<String> uniqueStrings = new HashSet<>();

        for (Product_Classify productClassify : productClassifies) {
            uniqueStrings.add(productClassify.getClassificationName1()); // Hoặc thay thế bằng productClassify.getClassificationName2()
        }

        ArrayList<String> strings = new ArrayList<>(uniqueStrings);
        strings.forEach(string -> {
            ArrayList<ProductClassifyDTO> productClassifyDTOS = new ArrayList<>();

            ProductClassifySlimDTO productClassifySlimDTO = new ProductClassifySlimDTO();

            productClassifies.forEach(productClassify -> {
                if (!strings.isEmpty() && productClassify.getClassificationName1().equals(string)) {
//                    set classification1 cho classificationSlim
                    productClassifySlimDTO.setClassificationName1(productClassify.getClassificationName1());
//                    set mảng cho classificationSlim
                    ProductClassifyDTO productClassifyDTO = new ProductClassifyDTO(
                            productClassify.getClassificationName2(),
                            productClassify.getQuantity()
                    );
                    productClassifyDTOS.add(productClassifyDTO);
                }
            });
            productClassifySlimDTO.setProductClassifyDTOArrayList(productClassifyDTOS);
            productClassifySlimDTOS.add(productClassifySlimDTO);
        });
//
        return productClassifySlimDTOS;
    }
    public double priceAfterDiscount(ProductGetDTO productGetDTO) {
        double price = productGetDTO.getPrice();
        if (productGetDTO.getDiscount() != null) {
            double percent = productGetDTO.getDiscount().getValue();

            return price * (100 - percent) / 100;
        }
        return price;
    }
    @Override
    public ProductGetDTO productToProductGetDTO(Product product) {
        if (product == null) {
            return null;
        }

        ProductGetDTO productGetDTO = new ProductGetDTO();

        productGetDTO.setId(product.getProductId());
        productGetDTO.setProductName(product.getProductName());
        productGetDTO.setDescription(product.getDescription());
        productGetDTO.setTotalRate(product.getTotalRate());
        productGetDTO.setRatings(product.getRatings());
        productGetDTO.setPrice(product.getPrice());
//        productGetDTO.setClassification2(product.getClassification2());

        String classificationName1 = product.getClassification1();
        ArrayList<String> classification1 = new ArrayList<>();
        classification1 = getClassifyByProductId(product.getProductId(), 1);
        productGetDTO.setClassification1(new ClassifiesSlimDTO(
                classificationName1,
                classification1
        ));
        String classificationName2 = product.getClassification2();
        ArrayList<String> classification2 = new ArrayList<>();
        classification2 = getClassifyByProductId(product.getProductId(), 2);
        productGetDTO.setClassification2(new ClassifiesSlimDTO(
                classificationName2,
                classification2
        ));

        List<Product_brand_origin> PBO = getProductBOByProductId(productGetDTO.getId());
        int brandId = PBO.get(0).getBrand().getBrandId();
        Brand brand = getBrandsByID(brandId);
        productGetDTO.setBrands(brandToBrandSlimDTO (brand));

//        List images product
        ArrayList<String> images = new ArrayList<>();
        images = getImagesByProductId(product.getProductId());
        productGetDTO.setImages(images);

//        productGetDTO.setImages(classify);

//        set discount
        Discount discount = discountRepository.findDiscountByProductProductId(product.getProductId());
        productGetDTO.setDiscount(discToDiscSlimDTO(discount));
        productGetDTO.setPriceAfterDiscount(priceAfterDiscount(productGetDTO));

//        set category
        List<Product_Category> PC = getProductCategoryByProductId(productGetDTO.getId());
        int subCategoryId = PC.get(0).getSubCategory().getSubCategoryId();
        SubCategory subCategory = getSubCategoryByID(subCategoryId);
        productGetDTO.setSubCategory(subCategory);

//        set list classifies
        ArrayList<ProductClassifySlimDTO> productClassifySlimDTOS = getProductClassify(productGetDTO.getId());
        productGetDTO.setClassifications(productClassifySlimDTOS);
//        productGetDTO.setClassifications(null);

        return productGetDTO;
    }
}
