package com.tms.shop.services;

import com.tms.shop.entities.User;
import com.tms.shop.exceptions.AuthorizationException;
import java.util.List;
import org.springframework.web.servlet.ModelAndView;

public interface UserService {

    List<User> read();

    User getUserByEmail(String email);

    void registration(User user);

    void edit(User user);
}