package com.tms.shop.services;

import com.tms.shop.entities.Category;
import java.util.List;
import org.springframework.web.servlet.ModelAndView;

public interface CategoryService {

    List<Category> getCategories();

    ModelAndView getCategoryData(int id);
}