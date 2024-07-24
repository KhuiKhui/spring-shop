package com.example.spring_shop.repos;

import com.example.spring_shop.entities.impl.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product, Integer> {
    List<Product> findByIsActive(boolean isActive);
}