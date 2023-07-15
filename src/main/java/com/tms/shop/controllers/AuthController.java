package com.tms.shop.controllers;

import static com.tms.shop.utils.Constants.EDIT_PAGE;
import static com.tms.shop.utils.Constants.REGISTER_PAGE;
import static com.tms.shop.utils.Constants.SIGN_PAGE;

import com.tms.shop.dto.UserDto;
import com.tms.shop.entities.User;
import com.tms.shop.services.UserService;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class AuthController {

    private final UserService userService;

    public AuthController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/login")
    public String openLoginPage() {
        return SIGN_PAGE;
    }

    @GetMapping("/register")
    public String openRegisterPage(Model model) {
        User user = new User();
        model.addAttribute("user", user);
        return REGISTER_PAGE;
    }

    @PostMapping("/register")
    public String registerUser(@ModelAttribute("user") User user, Model model) {
        String email = user.getEmail();
        User existingUser = userService.getUserByEmail(email);
        if (existingUser != null) {
            model.addAttribute("error", "Email already exists");
            return REGISTER_PAGE;
        }
        userService.registration(user);
        return "redirect:/register?success";
    }

    @GetMapping("/edit")
    public String editUserPage(Model model, @AuthenticationPrincipal(expression = "username") String email) {
        User user = userService.getUserByEmail(email);
        model.addAttribute("user", user);
        return EDIT_PAGE;
    }

    @PostMapping("/edit")
    public String editUser(@ModelAttribute("user") UserDto user) {
        userService.edit(user);
        return "redirect:/profile";
    }
}

