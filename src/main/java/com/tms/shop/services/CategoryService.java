package com.tms.shop.services;

import com.tms.shop.entities.Category;
import java.util.List;

public interface CategoryService {

    List<Category> getCategories();

    Category getCategory(Long id);

}