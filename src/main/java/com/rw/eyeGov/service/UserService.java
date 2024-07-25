package com.rw.eyeGov.service;


import com.rw.eyeGov.dto.ELifeCycle;
import com.rw.eyeGov.dto.ERole;
import com.rw.eyeGov.dto.UserDto;
import com.rw.eyeGov.exception.ResourceExistsException;
import com.rw.eyeGov.exception.ResourceNotFoundException;
import com.rw.eyeGov.model.User;
import com.rw.eyeGov.repository.IUserRepository;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;
import java.util.UUID;
@Service
@Transactional
@AllArgsConstructor
public class UserService implements IUserService {

    private final IUserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    @Override
    public User createUser(UserDto userDto) {
        if (userRepository.findUserByEmail(userDto.getEmail()).isPresent()) {
            throw new ResourceExistsException("User with such email already exists.");
        }
        User user = new User();
        user.setEmail(userDto.getEmail());
        user.setUsername(userDto.getEmail());
        user.setPassword(passwordEncoder.encode(userDto.getPassword()));
        user.setFullName(userDto.getFullName());
        user.setRole(ERole.USER);
        user.setState(ELifeCycle.CREATED);
        return userRepository.save(user);
    }

    @Override
    public User updateUser(UUID userId, UserDto userDto) {
        User userToUpdate = userRepository.findById(userId).orElseThrow(() -> new ResourceNotFoundException("User not found."));
        Optional<User> existingUser = userRepository.findUserByEmail(userDto.getEmail());
        if (existingUser.isPresent() && !existingUser.get().getId().equals(userId)) {
            throw new ResourceExistsException("User with such email already exists.");
        }
        userToUpdate.setEmail(userDto.getEmail());
        userToUpdate.setUsername(userDto.getUsername());
        return userRepository.save(userToUpdate);
    }

    @Override
    public User disableUser(UUID userId) {
        User userToUpdate = userRepository.findById(userId).orElseThrow(() -> new ResourceNotFoundException("User not found."));
        userToUpdate.setState(ELifeCycle.INACTIVE);
        return userRepository.save(userToUpdate);
    }

    @Override
    public Page<User> getAllUsers(Pageable pageable) {
        return userRepository.findAll(pageable);
    }

    @Override
    public User findUser(UUID userId) {
        return userRepository.findById(userId).orElseThrow(() -> new ResourceNotFoundException("User not found."));
    }

    @Override
    public Page<User> searchUser(String searchParam, Pageable pageable) {
        // TODO: CREATE QUERY TO SEARCH USERS;
        return null;
    }

    @Override
    public User findByUsername(String username) {
        return userRepository.findUserByUsername(username).orElseThrow(() -> new ResourceNotFoundException("User not found"));
    }
}

