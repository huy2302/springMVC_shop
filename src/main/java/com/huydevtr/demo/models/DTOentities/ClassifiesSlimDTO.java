package com.huydevtr.demo.models.DTOentities;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.ArrayList;

@Data
public class ClassifiesSlimDTO {
    @JsonProperty("name")
    private String name;
    @JsonProperty("classifies")
    private ArrayList<String> classifies;

    public ClassifiesSlimDTO() {
    }

    public ClassifiesSlimDTO(String name, ArrayList<String> classifies) {
        this.name = name;
        this.classifies = classifies;
    }
}
