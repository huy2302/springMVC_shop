package com.huydevtr.demo.models.entities;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
@Entity
@Getter
@Setter
@Table(name = "brand")
public class Brand {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "brandId")
    private Integer brandId;

    @Column(name = "brandName")
    private String brandName;

    @Column(name = "description")
    private String description;
    @Column(name = "shortBrand")
    private String shortBrand;

    public Brand () {}

    public Brand(Integer brandId, String brandName, String description, String shortBrand) {
        this.brandId = brandId;
        this.brandName = brandName;
        this.description = description;
        this.shortBrand = shortBrand;
    }
}
