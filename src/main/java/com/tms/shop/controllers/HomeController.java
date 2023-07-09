package com.tms.shop.controllers;

import static com.tms.shop.utils.Constants.HOME_PAGE;

import com.tms.shop.entities.Category;
import com.tms.shop.entities.User;
import com.tms.shop.services.CategoryService;
import java.util.List;

import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.servlet.ModelAndView;

@Setter
@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/home")
public class HomeController {

    private final CategoryService categoryService;

    @GetMapping
    public ModelAndView openHomePage(@SessionAttribute("user") User user) {
        log.info("User with email: {} successfully logged in!", user.getEmail());
        List<Category> categoriesList = categoryService.getCategories();
        ModelMap model = new ModelMap("categories", categoriesList);
        return new ModelAndView(HOME_PAGE, model);
    }
}