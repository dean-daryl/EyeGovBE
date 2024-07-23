package com.rw.eyeGov.service;

import com.rw.eyeGov.config.JWTUtils;
import com.rw.eyeGov.dto.LoginRequest;
import com.rw.eyeGov.dto.LoginResponse;
import com.rw.eyeGov.exception.BadRequestException;
import com.rw.eyeGov.exception.ResourceNotFoundException;
import com.rw.eyeGov.model.User;
import com.rw.eyeGov.repository.IUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthService {
    @Autowired
    private UserDetailsService userPrincipalDetailService;
    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private JWTUtils jwtUtils;

    @Autowired
    private IUserRepository userRepository;

    public LoginResponse login(LoginRequest authenticationRequest) {
        try {
           authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(authenticationRequest.getUsername(),authenticationRequest.getPassword()));
           User user =userRepository.findUserByEmail(authenticationRequest.getUsername()).orElseThrow(()-> new ResourceNotFoundException("User not found!"));
            String token = jwtUtils.generateToken(user);
            LoginResponse loginResponse = new LoginResponse();
            loginResponse.setToken(token);
            loginResponse.setUser(user);
            return loginResponse;

        }catch (Exception exception){
            throw new BadRequestException(exception.getMessage());
        }


    }

}
