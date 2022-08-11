package com.etiya.northwind.api.controllers;

import com.etiya.northwind.business.abstracts.ProductService;
import com.etiya.northwind.business.requests.orders.DeleteOrderRequest;
import com.etiya.northwind.business.requests.orders.UpdateOrderRequest;
import com.etiya.northwind.business.requests.products.CreateProductRequest;
import com.etiya.northwind.business.requests.products.DeleteProductRequest;
import com.etiya.northwind.business.requests.products.UpdateProductRequest;
import com.etiya.northwind.business.responses.products.ProductListResponse;
import com.etiya.northwind.core.utilities.results.DataResult;
import com.etiya.northwind.core.utilities.results.Result;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/products")
public class ProductsController {

    private ProductService productService;

    public ProductsController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/getAll")
    public DataResult<List<ProductListResponse>> getAll(){
       return productService.getAll();
    }

    @PostMapping("/add")
    public Result add(@RequestBody @Valid CreateProductRequest createProductRequest){
       return this.productService.add(createProductRequest);
    }

    @PutMapping("/update")
    public Result update(@RequestBody @Valid UpdateProductRequest updateProductRequest){
        return this.productService.update(updateProductRequest);
    }

    @DeleteMapping("/delete")
    public Result delete(@RequestBody DeleteProductRequest deleteOrderRequest){
        return this.productService.delete(deleteOrderRequest);
    }
}
