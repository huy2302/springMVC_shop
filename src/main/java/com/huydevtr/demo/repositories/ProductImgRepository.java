package com.huydevtr.demo.repositories;

import com.huydevtr.demo.models.entitiesLink.ProductImg;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProductImgRepository extends JpaRepository<ProductImg, Integer> {
    List<ProductImg> findByImgUrl(String imgUrl);
    List<ProductImg> findAllByProductProductId (int imageId);
}
