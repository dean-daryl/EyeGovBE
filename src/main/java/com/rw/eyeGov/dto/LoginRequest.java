package com.rw.eyeGov.dto;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class LoginRequest {
    @NotEmpty
    @NotNull
    private String username;

    @NotEmpty
    @NotNull
    private String password;


    public LoginRequest(String username, String password) {
        this.username = username;
        this.password = password;
    }
    public boolean isForgotPassword() {
        return true;
    }
}

