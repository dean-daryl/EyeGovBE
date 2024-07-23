package com.rw.eyeGov.dto;

import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
public class UserDto {
    private String username;
    @Enumerated(EnumType.STRING)
    private EGender gender;

    @NotEmpty
    @NotNull
    private String nationalId;

    @NotEmpty
    @NotNull
    @Size(min = 12,max = 12)
    private String phoneNumber;

    @NotEmpty
    @NotNull
    private String email;
    @NotEmpty
    @NotNull
    private LocalDate dateOfBirth;

    @NotEmpty
    @NotNull
    private String password;

    @NotEmpty
    @NotNull
    private ERole role;
}

