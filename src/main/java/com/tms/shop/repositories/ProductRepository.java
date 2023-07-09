package com.tms.shop.repositories;

import com.tms.shop.entities.Product;
import java.util.List;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends CrudRepository<Product, Integer> {

    List<Product> findAll();

    Product findById(Long id);

    List<Product> findAllByCategory_Id(Long id);

}