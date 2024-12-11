package com.example.CQRS_Demo.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.CQRS_Demo.entity.Product;
import com.example.CQRS_Demo.repository.ProductQueryRepository;

@Service
public class ProductQueryService {

    private final ProductQueryRepository queryRepository;

    public ProductQueryService(ProductQueryRepository queryRepository) {
        this.queryRepository = queryRepository;
    }

    public Product getProductById(Long id) {
        return queryRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Product not found"));
    }

    public List<Product> getAllProducts() {
        return queryRepository.findAll();
    }
}
