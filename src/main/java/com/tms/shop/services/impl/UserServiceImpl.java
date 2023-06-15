package com.tms.shop.services.impl;

import static com.tms.shop.utils.Constants.HOME_PAGE;

import com.tms.shop.entities.Category;
import com.tms.shop.entities.User;
import com.tms.shop.exceptions.AuthorizationException;
import com.tms.shop.repositories.UserRepository;
import com.tms.shop.services.CategoryService;
import com.tms.shop.services.UserService;
import java.util.List;
import java.util.Optional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.ui.ModelMap;
import org.springframework.web.servlet.ModelAndView;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    private final CategoryService categoryService;

    @Override
    public ModelAndView authenticate(User user) throws AuthorizationException {
        ModelAndView modelAndView = new ModelAndView();
        User loggedUser = userRepository.findByEmailAndPassword(user.getEmail(), user.getPassword());
        if (Optional.ofNullable(loggedUser).isPresent()) {
            ModelMap modelMap = new ModelMap();
            List<Category> categoriesList = categoryService.getCategories();
            modelMap.addAttribute("categories", categoriesList);
            modelAndView.setViewName(HOME_PAGE);
            modelAndView.addAllObjects(modelMap);
        } else {
            throw new AuthorizationException("User is not authorized! Please, try again!");
        }
        return modelAndView;
    }

    @Override
    public List<User> read() {
        return userRepository.findAll();
    }
}