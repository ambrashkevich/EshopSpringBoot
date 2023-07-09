package com.tms.shop.controllers;

import com.tms.shop.entities.User;
import com.tms.shop.exceptions.AuthorizationException;
import com.tms.shop.repositories.UserRepository;
import com.tms.shop.services.UserService;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.ModelAndView;

@Controller
@SessionAttributes("user")
@RequestMapping("/auth")
public class AuthController {

    private final UserService userService;
    private final UserRepository userRepository;

    public AuthController(UserService userService, UserRepository userRepository) {
        this.userService = userService;
        this.userRepository = userRepository;
    }

    @GetMapping("/login")
    public ModelAndView openLoginPage() {
        return new ModelAndView("signin");
    }

    @PostMapping("/login")
    public ModelAndView login(@ModelAttribute("user") @Valid User user, BindingResult bindingResult) throws AuthorizationException {
        if (bindingResult.hasErrors()) {
            return new ModelAndView("signin");
        }
        return userService.authenticate(user);
    }

    @ModelAttribute("user")
    public User setUpUserForm() {
        return new User();
    }

    @GetMapping("/register")
    public ModelAndView openRegisterPage() {
        return new ModelAndView("register");
    }

    @GetMapping("/agreement")
    public ModelAndView openAgreementPage() {
        return new ModelAndView("agreement");
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
        return "redirect:/auth/register?success";
    }

    @GetMapping("/logout")
    public ModelAndView openLogoutPage(@SessionAttribute("user") User user, SessionStatus sessionStatus) {
        sessionStatus.setComplete();
        return new ModelAndView("signin");
    }
}

