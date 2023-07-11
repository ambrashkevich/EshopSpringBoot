package com.tms.shop.services.impl;

import com.tms.shop.entities.Product;
import com.tms.shop.repositories.ProductRepository;
import com.tms.shop.services.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;

    @Override
    public Page<Product> getProductsByCategoryId(Long categoryId, int pageNumber, int pageSize) {
        return productRepository.findAllByCategory_Id(categoryId, PageRequest.of(pageNumber, pageSize));
    }

    @Override
    public Product getProductById(Long id) {
        return productRepository.getProductById(id);
    }

    @Override
    public Page<Product> getProductsByCategory(Long id, int pageNumber, int pageSize) {
        return productRepository.findAllByCategory_Id(id, PageRequest.of(pageNumber, pageSize));
    }

    @Override
    public Page<Product> getProducts(String productName, int pageNumber, int pageSize) {
        return productRepository.findAllWithSearch(productName, PageRequest.of(pageNumber, pageSize));
    }
}