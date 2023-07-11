package com.tms.shop.controllers;

import static com.tms.shop.utils.Constants.PROFILE_PAGE;

import com.tms.shop.entities.User;
import com.tms.shop.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/profile")
public class ProfileController {

    @Autowired
    private UserService userService;

    @GetMapping
    public String openProfilePage(Model model, @AuthenticationPrincipal(expression = "username") String email) {
        User user = userService.getUserByEmail(email);
        model.addAttribute("user", user);
        return PROFILE_PAGE;
    }
}