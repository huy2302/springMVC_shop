package com.huydevtr.demo.models.DTOentities;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class UserSlimDTO {
    @JsonProperty("userId")
    private int userId;
    @JsonProperty("userName")
    private String userName;
    @JsonProperty("birthDay")
    private String birthDay;
    @JsonProperty("email")
    private String email;
    @JsonProperty("phoneNo")
    private String phoneNo;

    public UserSlimDTO() {
    }

    public UserSlimDTO(int userId, String userName, String birthDay, String email, String phoneNo) {
        this.userId = userId;
        this.userName = userName;
        this.birthDay = birthDay;
        this.email = email;
        this.phoneNo = phoneNo;
    }
}
