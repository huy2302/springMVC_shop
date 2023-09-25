package com.huydevtr.demo.models.DTOentities;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.ArrayList;

@Data
public class ProductClassifySlimDTO {
    @JsonProperty("classificationName1")
    private String classificationName1;

    @JsonProperty("classificationDetails")
    ArrayList<ProductClassifyDTO> productClassifyDTOArrayList;

    public ProductClassifySlimDTO() {
    }

    public ProductClassifySlimDTO(String classificationName1, ArrayList<ProductClassifyDTO> productClassifyDTOArrayList) {
        this.classificationName1 = classificationName1;
        this.productClassifyDTOArrayList = productClassifyDTOArrayList;
    }
}
