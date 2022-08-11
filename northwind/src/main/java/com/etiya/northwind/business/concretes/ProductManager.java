package com.etiya.northwind.business.concretes;

import com.etiya.northwind.business.abstracts.ProductService;
import com.etiya.northwind.business.dtos.APIResponse;
import com.etiya.northwind.business.requests.products.CreateProductRequest;
import com.etiya.northwind.business.requests.products.DeleteProductRequest;
import com.etiya.northwind.business.requests.products.UpdateProductRequest;
import com.etiya.northwind.business.responses.employees.ReadEmployeeResponse;
import com.etiya.northwind.business.responses.products.ProductListResponse;
import com.etiya.northwind.business.responses.products.ReadProductResponse;
import com.etiya.northwind.core.utilities.exceptions.BusinessException;
import com.etiya.northwind.core.utilities.mapping.ModelMapperService;
import com.etiya.northwind.core.utilities.results.DataResult;
import com.etiya.northwind.core.utilities.results.Result;
import com.etiya.northwind.core.utilities.results.SuccessDataResult;
import com.etiya.northwind.core.utilities.results.SuccessResult;
import com.etiya.northwind.dataAccess.ProductRepository;
import com.etiya.northwind.entities.concretes.Category;
import com.etiya.northwind.entities.concretes.Product;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
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
    public DataResult<List<ProductListResponse>> getAll() {
        List<Product> result = productRepository.findAll();
        //stream ben ürünleri dolaşcam demek map de dolaşırken ben ne yapayım diyo ikinci map ise
        List<ProductListResponse> response = result.stream().map(product ->  this.modelMapperService.forResponse().map(product,ProductListResponse.class)).collect(Collectors.toList());
        return new SuccessDataResult<List<ProductListResponse>>(response);

    }

    @Override
    public Result add(CreateProductRequest createProductRequest) {
        checkIfCategoryLimitExceeds(createProductRequest.getCategoryId());
        checkIfProductExistsByName(createProductRequest.getProductName());

        Product product = this.modelMapperService.forRequest().map(createProductRequest,Product.class);
        this.productRepository.save(product);

        return new SuccessResult("PRODUCT.ADDED");
    }

    @Override
    public Result update(UpdateProductRequest updateProductRequest) {
        Product product = this.modelMapperService.forRequest().map(updateProductRequest,Product.class);
        this.productRepository.save(product);
        return new SuccessResult("PRODUCT.UPDATED");
    }

    @Override
    public Result delete(DeleteProductRequest deleteProductRequest) {
        Product product = this.modelMapperService.forRequest().map(deleteProductRequest,Product.class);
        this.productRepository.delete(product);
        return new SuccessResult("PRODUCT.DELETED");
    }

    @Override
    public DataResult<ReadProductResponse> getById(int id) {
        Product product = this.productRepository.findById(id).get();
        ReadProductResponse readProductResponse = this.modelMapperService.forResponse().map(product, ReadProductResponse.class);

        return new SuccessDataResult<ReadProductResponse>(readProductResponse);
    }

    @Override
    public Product getByProductId(int id) {
        Product product = this.productRepository.findById(id).get();
        return product;
    }

    @Override
    public List<ProductListResponse> getProductsWithSorting(String field) {
        List<Product> result= productRepository.findAll(Sort.by(Sort.Direction.ASC,field));
        List<ProductListResponse> response =
                result.stream().map(product -> this.modelMapperService.forResponse()
                        .map(product, ProductListResponse.class)).collect(Collectors.toList());

        return response;
    }

    @Override
    public APIResponse<List<ProductListResponse>> findProductsWithPagination(int pageNumber, int pageSize) {
        Pageable pageable = PageRequest.of(pageNumber - 1, pageSize);
        Page<Product> resultPage =  this.productRepository.findAll(pageable);//buraya dön
        List<Product> result = this.productRepository.findAll(pageable).getContent();



        List<ProductListResponse> response = result.stream()
                .map(product -> this.modelMapperService.forResponse().map(product, ProductListResponse.class))
                .collect(Collectors.toList());

        return new APIResponse<List<ProductListResponse>>( pageSize,result.size(),pageNumber,resultPage.getPageable().getPageSize(),response) ;
    }

    @Override
    public APIResponse<List<ProductListResponse>> findProductsWithPaginationAndSorting2(int pageNumber, int pageSize, String field) {
        Pageable pageable = PageRequest.of(pageNumber - 1, pageSize).withSort(Sort.by(field));
        List<Product> resultPage =  this.productRepository.findAll();
        List<Product> result = this.productRepository.findAll(pageable).getContent();
        List<ProductListResponse> response = result.stream()
                .map(product -> this.modelMapperService.forResponse().map(product, ProductListResponse.class))
                .collect(Collectors.toList());
        return new APIResponse<List<ProductListResponse>>(pageSize,result.size(),pageNumber,resultPage.size(),response) ;
    }

    private void checkIfCategoryLimitExceeds(int id){
        List<Product> products = this.productRepository.findByCategory_CategoryId(id);
        if (products.size() >= 14){
            throw new BusinessException("Category limit exceeded");
        }
    }

    private void checkIfProductExistsByName(String name){
        Product currentProduct = this.productRepository.findByProductName(name);
        if (currentProduct != null){
            throw new BusinessException("Product name already exists");
        }
    }
}
