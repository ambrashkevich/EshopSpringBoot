package com.tms.shop.repositories;

import com.tms.shop.entities.User;
import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    Optional<User> findById(Long id);

    List<User> findAll();

    User findByEmailAndPassword(String email, String password);

    User findByEmail(String email);
}