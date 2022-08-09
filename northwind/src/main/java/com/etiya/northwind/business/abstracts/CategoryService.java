package com.etiya.northwind.business.abstracts;

import com.etiya.northwind.business.responses.categories.CategoryListResponse;

import java.util.List;

public interface CategoryService {
    List<CategoryListResponse> getAll();
}
