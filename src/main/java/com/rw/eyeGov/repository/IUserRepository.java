package com.rw.eyeGov.repository;

import com.rw.eyeGov.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface IUserRepository extends JpaRepository<User, UUID> {
    Optional<User> findUserByEmail(String email);
    Optional<User> findUserByUsername(String username);
}