package com.huydevtr.demo.models.entities;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name = "subCategory")
public class SubCategory {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "subCategoryId")
    private Integer subCategoryId;
    @Column(name = "subCategory")
    private String subCategory;
    @ManyToOne
    @MapsId("categoryId")
    @JoinColumn(name = "categoryId")
    Category category;

    public SubCategory() {
    }

    public SubCategory(Integer subCategoryId, Category category, String subCategory) {
        this.subCategoryId = subCategoryId;
        this.category = category;
        this.subCategory = subCategory;
    }
}
