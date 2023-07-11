package com.tms.shop.services;

import com.tms.shop.entities.Category;
import com.tms.shop.entities.Product;
import java.util.List;
import org.springframework.data.domain.Page;
import org.springframework.web.servlet.ModelAndView;

public interface CategoryService {

    List<Category> getCategories();


    Category getCategory(Long id);

}