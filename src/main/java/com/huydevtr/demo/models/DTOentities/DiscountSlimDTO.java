package com.huydevtr.demo.models.DTOentities;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class DiscountSlimDTO {
    @JsonProperty("discountId")
    private int discountId;
    @JsonProperty("value")
    private double value;
    @JsonProperty("startDay")
    private String startDay;
    @JsonProperty("endDay")
    private String endDay;

    public DiscountSlimDTO() {
    }

    public DiscountSlimDTO(int discountId, double value, String startDay, String endDay) {
        this.discountId = discountId;
        this.value = value;
        this.startDay = startDay;
        this.endDay = endDay;
    }
}
