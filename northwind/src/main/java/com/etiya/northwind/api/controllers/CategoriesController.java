package com.etiya.northwind.api.controllers;

import com.etiya.northwind.business.abstracts.CategoryService;
import com.etiya.northwind.business.requests.categories.CreateCategoryRequest;
import com.etiya.northwind.business.requests.categories.DeleteCategoryRequest;
import com.etiya.northwind.business.requests.categories.UpdateCategoryRequest;
import com.etiya.northwind.business.responses.categories.CategoryListResponse;
import com.etiya.northwind.business.responses.categories.ReadCategoryResponse;
import com.etiya.northwind.core.utilities.results.DataResult;
import com.etiya.northwind.core.utilities.results.Result;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/categories")
public class CategoriesController {
    private CategoryService categoryService;

    public CategoriesController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @GetMapping("/getAll")
    public DataResult<List<CategoryListResponse>> getAll(){
        return categoryService.getAll();
    }

    @GetMapping("/getbyid")
    public DataResult<ReadCategoryResponse> getById(int id)
    {
        return categoryService.getById(id);
    }

    @PostMapping("/add")
    public Result add(@RequestBody CreateCategoryRequest createCategoryRequest) {
        return this.categoryService.add(createCategoryRequest);
    }

    @PutMapping("/update")
    public Result update(@RequestBody UpdateCategoryRequest updateCategoryRequest) {
        return this.categoryService.update(updateCategoryRequest);
    }

    @DeleteMapping("/delete")
    public Result delete(@RequestBody DeleteCategoryRequest deleteCategoryRequest) {
        return this.categoryService.delete(deleteCategoryRequest);
    }


}
