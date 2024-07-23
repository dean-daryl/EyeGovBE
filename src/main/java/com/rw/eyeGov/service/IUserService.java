package com.rw.eyeGov.service;

import com.rw.eyeGov.dto.UserDto;
import com.rw.eyeGov.model.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.UUID;

public interface IUserService {
    User createUser(UserDto userDto);
    User updateUser(UUID userId, UserDto userDto);
    User disableUser(UUID userId);
    Page<User> getAllUsers(Pageable pageable);
    User findUser(UUID userId);
    Page<User> searchUser(String searchParam, Pageable pageable);
    User findByUsername(String username);
}
