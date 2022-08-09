package com.etiya.northwind.business.concretes;

import com.etiya.northwind.business.abstracts.CategoryService;
import com.etiya.northwind.business.responses.categories.CategoryListResponse;
import com.etiya.northwind.business.responses.products.ProductListResponse;
import com.etiya.northwind.core.utilities.mapping.ModelMapperService;
import com.etiya.northwind.dataAccess.CategoryRepository;
import com.etiya.northwind.entities.concretes.Category;
import com.etiya.northwind.entities.concretes.Product;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CategoryManager implements CategoryService {

    private CategoryRepository categoryRepository;
    private ModelMapperService modelMapperService;

    public CategoryManager(CategoryRepository categoryRepository, ModelMapperService modelMapperService) {
        this.categoryRepository = categoryRepository;
        this.modelMapperService = modelMapperService;
    }

    @Override
    public List<CategoryListResponse> getAll() {
        List<Category> result = categoryRepository.findAll();
        List<CategoryListResponse> responses = result.stream().map(category ->  this.modelMapperService.forResponse().map(category,CategoryListResponse.class)).collect(Collectors.toList());
        return responses;
    }
}
