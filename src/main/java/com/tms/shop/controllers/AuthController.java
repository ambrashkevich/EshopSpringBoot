package com.tms.shop.controllers;

import com.tms.shop.entities.Role;
import com.tms.shop.entities.User;
import com.tms.shop.repositories.UserRepository;
import com.tms.shop.services.UserService;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
//@RequestMapping("/auth")
public class AuthController {


    private final UserService userService;

    public AuthController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/login")
    public String openLoginPage() {
        return "signin";
    }

    @GetMapping("/register")
    public String openRegisterPage(Model model) {
        User user = new User();
        model.addAttribute("user", user);
        return "register";
    }

    @PostMapping("/register")
    public String registerUser(@ModelAttribute("user") User user, Model model) {
        String email = user.getEmail();
        User existingUser = userService.getUserByEmail(email);
        if (existingUser != null) {
            model.addAttribute("error", "Email already exists");
            return "register";
        }
        userService.registration(user);
        return "redirect:/register?success";
    }
    @GetMapping("/edit")
    public String editUserPage(Model model, @AuthenticationPrincipal(expression = "username") String email) {
        User user = userService.getUserByEmail(email);
        model.addAttribute("user", user);
        return "edit";
    }

    @PostMapping("/edit")
    public String editUser(@ModelAttribute("user") User user) {
        userService.edit(user);
        return "redirect:/profile";
    }
}

