package com.tms.shop.services;

import com.tms.shop.dto.UserDto;
import com.tms.shop.entities.User;
import java.util.List;

public interface UserService {

    List<User> read();

    User getUserByEmail(String email);

    void registration(User user);

    void edit(UserDto user);
}