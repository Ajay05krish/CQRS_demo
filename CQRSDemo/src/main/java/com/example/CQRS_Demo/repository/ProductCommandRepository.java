package com.example.CQRS_Demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.CQRS_Demo.entity.Product;

public interface ProductCommandRepository extends JpaRepository<Product, Long> {
    // Only write operations will use this
}
