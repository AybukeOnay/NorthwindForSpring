package com.etiya.northwind.business.abstracts;

import com.etiya.northwind.business.dtos.APIResponse;
import com.etiya.northwind.business.requests.products.CreateProductRequest;
import com.etiya.northwind.business.requests.products.DeleteProductRequest;
import com.etiya.northwind.business.requests.products.UpdateProductRequest;
import com.etiya.northwind.business.responses.products.ProductListResponse;
import com.etiya.northwind.business.responses.products.ReadProductResponse;
import com.etiya.northwind.core.utilities.results.DataResult;
import com.etiya.northwind.core.utilities.results.Result;
import com.etiya.northwind.entities.concretes.Product;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

public interface ProductService {
    DataResult<List<ProductListResponse>> getAll();
    Result add(CreateProductRequest createProductRequest);
    Result update(UpdateProductRequest updateProductRequest);
    Result delete(DeleteProductRequest deleteProductRequest);

    DataResult<ReadProductResponse> getById(int id);
    Product getByProductId(int id);

    List<ProductListResponse> getProductsWithSorting(String field);
    APIResponse<List<ProductListResponse>> findProductsWithPagination(@PathVariable int pageNumber, @PathVariable int pageSize);

    APIResponse<List<ProductListResponse>> findProductsWithPaginationAndSorting2(int pageNumber, int pageSize,
                                                                                 String field);

}
