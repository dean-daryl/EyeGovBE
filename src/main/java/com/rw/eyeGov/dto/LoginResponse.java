package com.rw.eyeGov.dto;


import com.rw.eyeGov.model.User;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class LoginResponse {
    private  String token;

    private User user;

    public LoginResponse() {
        //Empty constructor
    }

    public LoginResponse(String token) {
        this.token = token;
    }

    public LoginResponse(String token, User user) {
        this.token = "Bearer " + token;
        this.user = user;
    }


}
