package com.tms.shop.services.impl;

import com.tms.shop.entities.Role;
import com.tms.shop.entities.User;
import com.tms.shop.repositories.UserRepository;
import com.tms.shop.services.CategoryService;
import com.tms.shop.services.UserService;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    @Qualifier("passwordEncoder")
    private final PasswordEncoder passwordEncoder;
    private final UserRepository userRepository;
    private final CategoryService categoryService;


    @Override
    public List<User> read() {
        return userRepository.findAll();
    }

    @Override
    public User getUserByEmail(String email) {
        return userRepository.findByEmail(email);
    }

    @Override
    public void registration(User user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        user.setRole(Role.ROLE_USER);
        userRepository.save(user);
    }

    @Override
    public void edit(User user) {
        userRepository.save(user);
    }
}