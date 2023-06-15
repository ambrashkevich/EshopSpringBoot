package com.tms.shop.controllers;

import com.tms.shop.entities.User;
import com.tms.shop.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @GetMapping("/register")
    public String showRegistrationForm(Model model) {
        model.addAttribute("user", new User());
        return "register";
    }

    @PostMapping("/register")
    public String registerUser(@ModelAttribute("user") User user, Model model) {
        String email = user.getEmail();
        User existingUser = userRepository.findByEmail(email);
        if (existingUser != null) {
            model.addAttribute("error", "Email already exists");
            return "register";
        }
        userRepository.save(user);
        return "redirect:/register?success";
    }
}