package com.tms.shop.controllers;

import static com.tms.shop.utils.Constants.HOME_PAGE;

import com.tms.shop.entities.Category;
import com.tms.shop.services.CategoryService;
import java.util.List;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;


@Setter
@Slf4j
@Controller
@RequiredArgsConstructor
public class HomeController {

    private final CategoryService categoryService;

    @GetMapping("/")
    public String openHomePage(Model model) {
        List<Category> categoriesList = categoryService.getCategories();
        model.addAttribute("categories", categoriesList);
        return HOME_PAGE;
    }
}