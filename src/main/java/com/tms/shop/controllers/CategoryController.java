package com.tms.shop.controllers;

import static com.tms.shop.utils.Constants.CATEGORY_PAGE;

import com.tms.shop.entities.Category;
import com.tms.shop.entities.Product;
import com.tms.shop.services.CategoryService;
import com.tms.shop.services.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
@RequiredArgsConstructor
@RequestMapping("/category")
public class CategoryController {

    private final CategoryService categoryService;
    private final ProductService productService;
    private final static int PAGE_SIZE = 4;

    @GetMapping("/{id}")
    public String openCategoryPage(Model model, @PathVariable Long id,
                                   @RequestParam(required = false, name = "page") Integer pageNumber,
                                   @RequestParam(required = false, name = "name") String searchProduct) {
        Category category = categoryService.getCategory(id);
        if (category != null) {
            int currentPage = 0;
            if (pageNumber != null) {
                currentPage = pageNumber - 1;
            }
            Page<Product> productsPage = productService.getProductsByCategory(category.getId(), currentPage, PAGE_SIZE);
            category.setProductList(productsPage.getContent());
            model.addAttribute("category", category);
            model.addAttribute("page", productsPage);
        }
        return CATEGORY_PAGE;
    }
}
