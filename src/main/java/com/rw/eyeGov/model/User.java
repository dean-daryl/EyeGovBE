package com.rw.eyeGov.model;
import com.rw.eyeGov.dto.EGender;
import com.rw.eyeGov.dto.ERole;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Entity
@Getter
@Setter
public class User extends BaseEntity implements UserDetails {
    private String username;

    private LocalDate dateOfBirth;

    private String phoneNumber;

    private String nationalId;

    private String email;

    private String tinNumber;

    private String password;

    private EGender gender;
    private ERole role;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return null;
    }

    @Override
    public String getPassword() {
        return this.password;
    }
}

