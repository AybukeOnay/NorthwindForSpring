package com.etiya.northwind.business.abstracts;

import com.etiya.northwind.business.requests.carts.CreateCartRequest;
import com.etiya.northwind.business.requests.carts.DeleteCartRequest;
import com.etiya.northwind.business.requests.carts.UpdateCartRequest;
import com.etiya.northwind.business.responses.carts.CartListResponse;
import com.etiya.northwind.business.responses.carts.ReadCartResponse;
import com.etiya.northwind.core.utilities.results.DataResult;
import com.etiya.northwind.core.utilities.results.Result;

import java.util.List;

public interface CartService {

    DataResult<List<CartListResponse>> getAll();
    Result add(CreateCartRequest createCartRequest);
    Result update(UpdateCartRequest updateCartRequest);
    Result delete(DeleteCartRequest deleteCartRequest);
    DataResult<ReadCartResponse> getById(int id);
}
