package com.huydevtr.demo.models.entities;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name = "user")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "userId")
    private Integer userId;
    @Column(name = "userName")
    private String userName;
    @Column(name = "birthDay")
    private String birthDay;
    @Column(name = "email")
    private String email;
    @Column(name = "password")
    private String password;
    @Column(name = "phoneNo")
    private String phoneNo;

    public User() {
    }

    public User(Integer userId, String userName, String birthDay, String email, String password, String phoneNo) {
        this.userId = userId;
        this.userName = userName;
        this.birthDay = birthDay;
        this.email = email;
        this.password = password;
        this.phoneNo = phoneNo;
    }
}
