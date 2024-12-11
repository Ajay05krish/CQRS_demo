package com.example.CQRS_Demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.CQRS_Demo.entity.Product;

public interface ProductQueryRepository extends JpaRepository<Product, Long> {
    // Only read operations will use this
}
