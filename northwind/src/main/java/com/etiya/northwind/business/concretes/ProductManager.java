package com.etiya.northwind.business.concretes;

import com.etiya.northwind.business.abstracts.ProductService;
import com.etiya.northwind.business.responses.products.ProductListResponse;
import com.etiya.northwind.core.utilities.mapping.ModelMapperService;
import com.etiya.northwind.dataAccess.ProductRepository;
import com.etiya.northwind.entities.concretes.Product;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProductManager implements ProductService {
    private ProductRepository productRepository;
    private ModelMapperService modelMapperService;

    public ProductManager(ProductRepository productRepository, ModelMapperService modelMapperService) {
        this.productRepository = productRepository;
        this.modelMapperService = modelMapperService;
    }

    @Override
    public List<ProductListResponse> getAll() {
        List<Product> result = productRepository.findAll();
        //stream ben ürünleri dolaşcam demek map de dolaşırken ben ne yapayım diyo ikinci map ise
        List<ProductListResponse> responses = result.stream().map(product ->  this.modelMapperService.forResponse().map(product,ProductListResponse.class)).collect(Collectors.toList());
        return  responses;
    }
}
