package com.test.demo.service;

import com.test.demo.model.Product;
import com.test.demo.model.ProductList;
import com.test.demo.repo.ProductListRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class ProductListService {
    @Autowired
    private ProductListRepository productListRepository;
    public List<ProductList> listAll() {
        return productListRepository.findAll();
    }
}
