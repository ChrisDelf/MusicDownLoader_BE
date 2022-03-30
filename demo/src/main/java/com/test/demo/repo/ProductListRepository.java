package com.test.demo.repo;


import com.test.demo.model.ProductList;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductListRepository extends JpaRepository<ProductList, Integer> {
}
