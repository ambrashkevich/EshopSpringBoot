package com.tms.shop.services;

import com.tms.shop.entities.CustomUserDetails;
import com.tms.shop.entities.User;
import com.tms.shop.repositories.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserDetailsService implements org.springframework.security.core.userdetails.UserDetailsService {
@Autowired
    private UserRepository userRepository;


    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        User user = userRepository.findByEmail(email);
        userRepository.save(user);
        if (user == null) {
            throw new UsernameNotFoundException( "Пользователь" + email + "не найден");
        }
        return new CustomUserDetails(user);
    }
}
