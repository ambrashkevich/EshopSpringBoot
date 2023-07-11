package com.tms.shop.services;

import com.tms.shop.entities.Product;
import org.springframework.data.domain.Page;

public interface ProductService {

    Page<Product> getProductsByCategoryId(Long categoryId, int pageNumber, int pageSize);

    Product getProductById(Long id);

    Page<Product> getProductsByCategory(Long id, int currentPage, int pageSize);

    Page<Product> getProducts(String productName, int currentPage, int pageSize);
}