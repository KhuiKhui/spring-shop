package com.example.spring_shop.repos;

import com.example.spring_shop.entities.impl.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Integer> {
    Optional<User> findByName(String name);

    List<User> findByIsActive(boolean isActive);
}