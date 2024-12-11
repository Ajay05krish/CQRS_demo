package com.example.CQRS_Demo.service;

import org.springframework.stereotype.Service;

import com.example.CQRS_Demo.entity.Product;
import com.example.CQRS_Demo.repository.ProductCommandRepository;

@Service
public class ProductCommandService {

    private final ProductCommandRepository commandRepository;

    public ProductCommandService(ProductCommandRepository commandRepository) {
        this.commandRepository = commandRepository;
    }

    public Product createProduct(Product product) {
        return commandRepository.save(product);
    }

    public Product updateProduct(Long id, Product product) {
        Product existingProduct = commandRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Product not found"));
        existingProduct.setName(product.getName());
        existingProduct.setPrice(product.getPrice());
        return commandRepository.save(existingProduct);
    }

    public void deleteProduct(Long id) {
        commandRepository.deleteById(id);
    }
}
