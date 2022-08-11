package com.etiya.northwind.business.concretes;

import com.etiya.northwind.business.abstracts.CategoryService;
import com.etiya.northwind.business.requests.categories.CreateCategoryRequest;
import com.etiya.northwind.business.requests.categories.DeleteCategoryRequest;
import com.etiya.northwind.business.requests.categories.UpdateCategoryRequest;
import com.etiya.northwind.business.responses.categories.CategoryListResponse;
import com.etiya.northwind.business.responses.products.ProductListResponse;
import com.etiya.northwind.core.utilities.mapping.ModelMapperService;
import com.etiya.northwind.core.utilities.results.DataResult;
import com.etiya.northwind.core.utilities.results.Result;
import com.etiya.northwind.core.utilities.results.SuccessDataResult;
import com.etiya.northwind.core.utilities.results.SuccessResult;
import com.etiya.northwind.dataAccess.CategoryRepository;
import com.etiya.northwind.entities.concretes.Category;
import com.etiya.northwind.entities.concretes.Product;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
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
    public DataResult<List<CategoryListResponse>> getAll() {
        List<Category> result = categoryRepository.findAll();
        List<CategoryListResponse> response = result.stream().map(category ->  this.modelMapperService.forResponse().map(category,CategoryListResponse.class)).collect(Collectors.toList());
        return new SuccessDataResult<List<CategoryListResponse>>(response);
    }

    @Override
    public Result add(CreateCategoryRequest createCategoryRequest) {
        Category category = this.modelMapperService.forRequest().map(createCategoryRequest,Category.class);
        this.categoryRepository.save(category);
        return new SuccessResult("CATEGORY.ADDED");
    }

    @Override
    public Result update(UpdateCategoryRequest updateCategoryRequest) {
        if(checkIfCategoryExitsById(updateCategoryRequest.getCategoryId())) {
            Category category = this.modelMapperService.forRequest().map(updateCategoryRequest, Category.class);
            this.categoryRepository.save(category);

        }
        return new SuccessResult("CATEGORY.UPDATED");
    }

    @Override
    public Result delete(DeleteCategoryRequest deleteCategoryRequest) {
        if(checkIfCategoryExitsById(deleteCategoryRequest.getCategoryId())) {
            Category category = this.modelMapperService.forRequest().map(deleteCategoryRequest, Category.class);
            this.categoryRepository.delete(category);

        }
        return new SuccessResult("CATEGORY.DELETED");
    }

    private boolean checkIfCategoryExitsById(int id)  {
        boolean exists=false;
        if(categoryRepository.findById(id).get()!=null) {
            exists=true;
            System.out.println("CATEGORY.ID.ALREADY.EXİSTS ");
        }
        return exists;
    }


}
