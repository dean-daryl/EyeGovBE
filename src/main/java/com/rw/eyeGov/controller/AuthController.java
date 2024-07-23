package com.rw.eyeGov.controller;

import com.rw.eyeGov.dto.LoginRequest;
import com.rw.eyeGov.dto.LoginResponse;
import com.rw.eyeGov.dto.UserDto;
import com.rw.eyeGov.model.User;
import com.rw.eyeGov.service.AuthService;
import com.rw.eyeGov.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/auth")
public class AuthController {
    @Autowired
    private AuthService authService;
    @Autowired
    private IUserService userService;

    @PostMapping("login")
    public LoginResponse login(@RequestBody LoginRequest loginRequest)
    {
        return authService.login(loginRequest);
    }
    @PostMapping("register")
    public User createUser(@RequestBody UserDto userDto){
        return userService.createUser(userDto);
    }
}
