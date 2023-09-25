package com.huydevtr.demo.models.entities;

import javax.persistence.*;
@Entity
@Table(name = "origin")
public class Origin {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "originId")
    private Integer originId;

    @Column(name = "originName")
    private String originName;

    @Column(name = "originAddress")
    private String originAddress;

    @Column(name = "description")
    private String description;

    @Column(name = "shortName")
    private String shortName;

    public Origin() {}
    public Origin(Integer originId, String originName, String originAddress, String description, String shortName) {
        this.originId = originId;
        this.originName = originName;
        this.originAddress = originAddress;
        this.description = description;
        this.shortName = shortName;
    }

    public Integer getOriginId() {
        return originId;
    }

    public void setOriginId(Integer originId) {
        this.originId = originId;
    }

    public String getOriginName() {
        return originName;
    }

    public void setOriginName(String originName) {
        this.originName = originName;
    }

    public String getOriginAddress() {
        return originAddress;
    }

    public void setOriginAddress(String originAddress) {
        this.originAddress = originAddress;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getShortName() {
        return shortName;
    }

    public void setShortName(String shortName) {
        this.shortName = shortName;
    }
}
