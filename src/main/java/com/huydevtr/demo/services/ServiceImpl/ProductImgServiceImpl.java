package com.huydevtr.demo.services.ServiceImpl;

import com.huydevtr.demo.models.ProductImageDTO;
import com.huydevtr.demo.models.entitiesLink.ProductImg;
import com.huydevtr.demo.repositories.ProductImgRepository;
import com.huydevtr.demo.services.ProductImgService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProductImgServiceImpl implements ProductImgService {
    private final ProductImgRepository productImgRepository;

    public ProductImgServiceImpl(ProductImgRepository productImgRepository) {
        this.productImgRepository = productImgRepository;
    }

    @Override
    public List<ProductImg> listImg() {
        return productImgRepository.findAll();
    }
    @Override
    public List<ProductImg> getProductsImagesByProductId(int productId) {
        List<ProductImg> productImgs = productImgRepository.findAllByProductProductId(productId);
//        ArrayList<String> images = new ArrayList<>();
        ArrayList<String> images = new ArrayList<>();
//        productImgs.forEach(productImg -> {
//            images.add(productImg.getImgUrl());
//        });
        images = getImagesByProductId(1);
        return productImgs;
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
    public List<ProductImg> getProductImagesByImgUrl(String imgUrl) {
        return productImgRepository.findByImgUrl(imgUrl);
    }

}
