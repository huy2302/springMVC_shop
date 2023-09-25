package com.huydevtr.demo.models.DTOentities;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class RatingSlimDTO {
    @JsonProperty("ratingId")
    private int ratingId;
    @JsonProperty("productId")
    private int productId;
    @JsonProperty("rating")
    private double rating;
    @JsonProperty("description")
    private String description;

    @JsonProperty("user")
    private UserSlimDTO userSlimDTO;

    public RatingSlimDTO() {
    }

    public RatingSlimDTO(int ratingId, int productId, UserSlimDTO userSlimDTO, double rating, String description) {
        this.ratingId = ratingId;
        this.productId = productId;
        this.userSlimDTO = userSlimDTO;
        this.rating = rating;
        this.description = description;
    }
}
