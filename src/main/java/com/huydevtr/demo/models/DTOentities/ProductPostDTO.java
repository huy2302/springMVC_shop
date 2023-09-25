package com.huydevtr.demo.models.DTOentities;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.sun.istack.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProductPostDTO {
    @JsonProperty("id")
    private int id;

    @NotNull
    @JsonProperty("productName")
    private String productName;

    @NotNull
    @JsonProperty("description")
    private String description;



}
