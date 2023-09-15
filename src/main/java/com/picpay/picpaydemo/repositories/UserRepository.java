package com.picpay.picpaydemo.repositories;

import com.picpay.picpaydemo.domain.user.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Optional;
import java.util.UUID;

public interface UserRepository extends JpaRepository<User, UUID> {
    Optional<User> findUserByDocument(String document);
    Optional<User> findUserById(String id);
    UserDetails findByEmail(String email);
}
