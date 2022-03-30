package com.test.demo.controller;

import com.test.demo.model.Product;
import com.test.demo.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ProductController {

    @Autowired
    private ProductService service;

    // RESTful API methods for Retrieval operations
    @GetMapping("/product")
    public List<Product> list() {
        return service.listAll();
    }

    // RESTful API method for Create operation

    // RESTful API method for Update operation

    // RESTful API method for Delete operation
}