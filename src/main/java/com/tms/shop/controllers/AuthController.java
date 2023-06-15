package com.tms.shop.controllers;

import static com.tms.shop.utils.Constants.SIGN_IN_PAGE;

import com.tms.shop.entities.User;
import com.tms.shop.exceptions.AuthorizationException;
import com.tms.shop.services.UserService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

@RequiredArgsConstructor
@RestController
@SessionAttributes({"user"})
@RequestMapping("/login")
public class AuthController {

    private final UserService userService;

    @GetMapping
    public ModelAndView openLoginPage() {
        return new ModelAndView(SIGN_IN_PAGE);
    }

    @PostMapping
    public ModelAndView login(@ModelAttribute("user") @Valid User user, BindingResult bindingResult, ModelAndView modelAndView) throws AuthorizationException {
        if (bindingResult.hasErrors()) {
            modelAndView.setViewName(SIGN_IN_PAGE);
            return modelAndView;
        }
        return userService.authenticate(user);
    }

    @ModelAttribute("user")
    public User setUpUserForm() {
        return new User();
    }
}
