package com.huydevtr.demo.models.DTOentities;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BrandSlimDTO {
    @JsonProperty("brandId")
    private int brandId;
    @JsonProperty("brandName")
    private String brandName;
    @JsonProperty("shortBrand")
    private String shortBrand;

    public BrandSlimDTO() {}

    public BrandSlimDTO(int brandId, String brandName, String shortBrand) {
        this.brandId = brandId;
        this.brandName = brandName;
        this.shortBrand = shortBrand;
    }
}
