package com.rw.eyeGov.controller;

import com.rw.eyeGov.dto.UserDto;
import com.rw.eyeGov.model.User;
import com.rw.eyeGov.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("user")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping
    public ResponseEntity<User> createUser(@RequestBody UserDto userDto) {
        User createdUser = userService.createUser(userDto);
        return new ResponseEntity<>(createdUser, HttpStatus.CREATED);
    }

    @PutMapping("/{userId}")
    public ResponseEntity<User> updateUser(@PathVariable UUID userId, @RequestBody UserDto userDto) {
        User updatedUser = userService.updateUser(userId, userDto);
        return new ResponseEntity<>(updatedUser, HttpStatus.OK);
    }

    @PatchMapping("/{userId}/disable")
    public ResponseEntity<User> disableUser(@PathVariable UUID userId) {
        User disabledUser = userService.disableUser(userId);
        return new ResponseEntity<>(disabledUser, HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<Page<User>> getAllUsers(Pageable pageable) {
        Page<User> users = userService.getAllUsers(pageable);
        return new ResponseEntity<>(users, HttpStatus.OK);
    }

    @GetMapping("/{userId}")
    public ResponseEntity<User> findUser(@PathVariable UUID userId) {
        User user = userService.findUser(userId);
        return new ResponseEntity<>(user, HttpStatus.OK);
    }

    @GetMapping("/search")
    public ResponseEntity<Page<User>> searchUser(@RequestParam String searchParam, Pageable pageable) {
        Page<User> users = userService.searchUser(searchParam, pageable);
        return new ResponseEntity<>(users, HttpStatus.OK);
    }
}
