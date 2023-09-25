package com.huydevtr.demo.services.ServiceImpl;

//import com.huydevtr.demo.models.DTO.ProductDTO;
import com.huydevtr.demo.models.entities.Product;
import com.huydevtr.demo.repositories.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProductDTOService {
    private ProductRepository productRepository;

//    public List<ProductDTO> getAllProduct() {
//        return productRepository.findAll()
//                .stream()
//                .map(product -> new ProductDTO(
//                        product.getProductId(),
//                        product.getProductName(),
//                        product.getDescription()
//                )).collect(Collectors.toList());
//    }
}
