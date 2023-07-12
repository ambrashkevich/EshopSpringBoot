package com.tms.shop.controllers;

import static com.tms.shop.utils.Constants.ADMIN_PAGE;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/admin")
public class AdminController {

    @GetMapping("/panel")
    public String openAdminPanel(Model model, @AuthenticationPrincipal(expression = "username") String email) {
        model.addAttribute("email", email);
        return ADMIN_PAGE;
    }
}
