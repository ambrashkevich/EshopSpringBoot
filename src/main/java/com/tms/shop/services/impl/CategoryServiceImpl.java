package com.tms.shop.services.impl;

import com.tms.shop.entities.Category;
import com.tms.shop.entities.Product;
import com.tms.shop.repositories.CategoryRepository;
import com.tms.shop.services.CategoryService;
import com.tms.shop.services.ProductService;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CategoryServiceImpl implements CategoryService {

    private final CategoryRepository categoryRepository;


    @Override
    public List<Category> getCategories() {
        return categoryRepository.findAll();
    }

    @Override
    public Category getCategory(Long id) {
        return categoryRepository.findCategoryById(id);
    }


}