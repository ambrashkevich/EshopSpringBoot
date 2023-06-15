package com.tms.shop.repositories;

import com.tms.shop.entities.User;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    User findById(int id);

    List<User> findAll();

    User findByEmailAndPassword(String email, String password);

}