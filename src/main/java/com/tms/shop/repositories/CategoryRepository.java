package com.tms.shop.repositories;

import com.tms.shop.entities.Category;

import java.util.List;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryRepository extends CrudRepository<Category, Integer> {
    List<Category> findAll();

    Category findCategoryById(int id);

}