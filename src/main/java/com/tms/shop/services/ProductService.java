package com.tms.shop.services;

import com.tms.shop.dto.ProductDto;
import com.tms.shop.entities.Product;
import org.springframework.data.domain.Page;

public interface ProductService {

    Product getProductById(Long id);

    Page<Product> getProductsByCategory(Long id, int currentPage, int pageSize, String sort);

    Page<Product> getProducts(String productName, int currentPage, int pageSize, String sort);

    void editProduct(ProductDto product);
}