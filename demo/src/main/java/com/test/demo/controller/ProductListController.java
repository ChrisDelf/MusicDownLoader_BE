package com.test.demo.controller;

import com.test.demo.model.Product;
import com.test.demo.model.ProductList;
import com.test.demo.service.ProductListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ProductListController {
    @Autowired
    private ProductListService productListService;

    @GetMapping("/product_lists")
    public List<ProductList> list() {
        return productListService.listAll();
    }
}
