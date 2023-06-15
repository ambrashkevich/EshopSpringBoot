package com.tms.shop.services;

import com.tms.shop.entities.User;
import com.tms.shop.exceptions.AuthorizationException;
import java.util.List;
import org.springframework.web.servlet.ModelAndView;

public interface UserService {
    ModelAndView authenticate(User user) throws AuthorizationException;

    List<User> read();
}