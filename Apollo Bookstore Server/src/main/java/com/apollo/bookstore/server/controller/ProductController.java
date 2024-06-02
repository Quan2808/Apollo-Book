package com.apollo.bookstore.server.controller;

import com.apollo.bookstore.library.entities.Product;
import com.apollo.bookstore.library.services.ProductService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/products/")
public class ProductController {

    private ProductService productService;

    @GetMapping()
    public List<Product> getAllProducts() {
        return productService.getProducts();
    }

}
