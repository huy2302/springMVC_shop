package com.huydevtr.demo.models.entities;

import javax.persistence.*;

@Entity
@Table (name = "subType")
public class SubTypeProduct {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "subTypeId")
    private int subTypeId;

    @Column(name = "subTypeName")
    private int subTypeName;

    @ManyToOne
    @MapsId("typeId")
    @JoinColumn(name = "typeId")
    TypeProduct typeProduct;

    public SubTypeProduct() {}
    public SubTypeProduct(int subTypeId, int subTypeName, TypeProduct typeProduct) {
        this.subTypeId = subTypeId;
        this.subTypeName = subTypeName;
        this.typeProduct = typeProduct;
    }

    public int getSubTypeId() {
        return subTypeId;
    }

    public void setSubTypeId(int subTypeId) {
        this.subTypeId = subTypeId;
    }

    public int getSubTypeName() {
        return subTypeName;
    }

    public void setSubTypeName(int subTypeName) {
        this.subTypeName = subTypeName;
    }

    public TypeProduct getTypeProduct() {
        return typeProduct;
    }

    public void setTypeProduct(TypeProduct typeProduct) {
        this.typeProduct = typeProduct;
    }
}
