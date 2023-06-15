package com.tms.shop.controllers;

import static com.tms.shop.utils.Constants.SIGN_IN_PAGE;

import com.tms.shop.entities.User;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.servlet.ModelAndView;

@RestController
@RequestMapping("/logout")
public class LogoutController {

    @GetMapping
    public ModelAndView openLogoutPage(@SessionAttribute("user") User user) {
        ModelMap modelMap = new ModelMap();
        modelMap.addAttribute("user", user);
        return new ModelAndView(SIGN_IN_PAGE, modelMap);
    }
}