package com.tms.shop.services.impl;

import static com.tms.shop.utils.Constants.CATEGORY_PAGE;

import com.tms.shop.entities.Category;
import com.tms.shop.entities.Product;
import com.tms.shop.repositories.CategoryRepository;
import com.tms.shop.services.CategoryService;
import com.tms.shop.services.ProductService;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.ui.ModelMap;
import org.springframework.web.servlet.ModelAndView;

@Service
@RequiredArgsConstructor
public class CategoryServiceImpl implements CategoryService {

    private final CategoryRepository categoryRepository;
    private final ProductService productService;

    @Override
    public List<Category> getCategories() {
        return categoryRepository.findAll();
    }

    @Override
    public ModelAndView getCategoryData(int id) {
        ModelMap model = new ModelMap();
        Category category = categoryRepository.findCategoryById(id);
        if (category != null) {
            List<Product> products = productService.getProductsByCategoryId(category.getId());
            category.setProductList(products);
            model.addAttribute("category", category);
        }
        return new ModelAndView(CATEGORY_PAGE, model);
    }
}