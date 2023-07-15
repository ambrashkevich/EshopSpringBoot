package com.tms.shop.services.impl;

import com.tms.shop.dto.ProductDto;
import com.tms.shop.entities.Product;
import com.tms.shop.repositories.ProductRepository;
import com.tms.shop.services.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;

    @Override
    public Product getProductById(Long id) {
        return productRepository.getProductById(id);
    }

    @Override
    public Page<Product> getProductsByCategory(Long id, int pageNumber, int pageSize, String sort) {
        return productRepository.findAllByCategory_Id(id, PageRequest.of(pageNumber, pageSize, createSort(sort)));
    }

    @Override
    public Page<Product> getProducts(String productName, int pageNumber, int pageSize, String sort) {
        return productRepository.findAllWithSearch(productName, PageRequest.of(pageNumber, pageSize, createSort(sort)));
    }

    @Override
    public void editProduct(ProductDto productDto) {
        Product product = productRepository.getProductById(productDto.getId());
        product.setName(productDto.getName());
        product.setDescription(productDto.getDescription());
        product.setPrice(productDto.getPrice());
        productRepository.save(product);
    }

    private Sort createSort(String sort) {
        if (sort.equals("min")) {
            return Sort.by("price").ascending();
        }
        return Sort.by("price").descending();
    }
}