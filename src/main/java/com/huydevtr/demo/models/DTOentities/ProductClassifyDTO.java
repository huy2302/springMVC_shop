package com.huydevtr.demo.models.DTOentities;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProductClassifyDTO {
    @JsonProperty("classificationName2")
    private String classificationName2;
    @JsonProperty("quantity")
    private int quantity;

    public ProductClassifyDTO() {
    }

    public ProductClassifyDTO(String classificationName2, int quantity) {
        this.classificationName2 = classificationName2;
        this.quantity = quantity;
    }
}
