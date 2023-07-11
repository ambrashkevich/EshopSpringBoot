package com.tms.shop.repositories;

import com.tms.shop.entities.Product;
import java.util.List;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {

    Product getProductById(Long id);

    List<Product> findAllByCategory_Id(Long id);

    Page<Product> findAllByCategory_Id(Long id, Pageable pageable);
    @Query("SELECT p FROM Product p WHERE p.name LIKE %?1%")
    Page<Product> findAllWithSearch(String search, Pageable pageable);

}