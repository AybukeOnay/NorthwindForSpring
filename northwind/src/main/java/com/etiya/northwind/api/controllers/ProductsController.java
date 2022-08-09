package com.etiya.northwind.api.controllers;

import com.etiya.northwind.business.abstracts.ProductService;
import com.etiya.northwind.business.responses.products.ProductListResponse;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/products")
public class ProductsController {

    private ProductService productService;

    public ProductsController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/getAll")
    public List<ProductListResponse> getAll(){
       return productService.getAll();
    }
}
