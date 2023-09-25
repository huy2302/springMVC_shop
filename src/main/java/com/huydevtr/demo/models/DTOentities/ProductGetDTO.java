package com.huydevtr.demo.models.DTOentities;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.huydevtr.demo.models.entities.SubCategory;
import com.sun.istack.NotNull;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;

@Getter
@Setter
public class ProductGetDTO {
    @JsonProperty("id")
    private int id;

    @NotNull
    @JsonProperty("productName")
    private String productName;

    @NotNull
    @JsonProperty("description")
    private String description;
    @JsonProperty("price")
    private double price;
    @JsonProperty("priceAfterDiscount")
    private double priceAfterDiscount;
    @JsonProperty("totalRate")
    private int totalRate;
    @JsonProperty("ratings")
    private double ratings;

    @JsonProperty("brands")
    private BrandSlimDTO brands;
    @JsonProperty("discount")
    private DiscountSlimDTO discount;
    @JsonProperty("subCategory")
    private SubCategory subCategory;
    @JsonProperty("classification1")
    private ClassifiesSlimDTO classification1;
    @JsonProperty("classification2")
    private ClassifiesSlimDTO classification2;
    @JsonProperty("classifications")
    private ArrayList<ProductClassifySlimDTO> classifications;
    @JsonProperty("images")
    private ArrayList<String> images;
}
