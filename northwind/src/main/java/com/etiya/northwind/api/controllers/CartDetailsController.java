package com.etiya.northwind.api.controllers;

import com.etiya.northwind.business.abstracts.CartDetailService;
import com.etiya.northwind.business.requests.cartDetails.CreateCartDetailRequest;
import com.etiya.northwind.business.requests.cartDetails.DeleteCartDetailRequest;
import com.etiya.northwind.business.requests.cartDetails.UpdateCartDetailRequest;
import com.etiya.northwind.business.responses.cartDetails.CartDetailListResponse;
import com.etiya.northwind.business.responses.cartDetails.ReadCartDetailResponse;
import com.etiya.northwind.core.utilities.results.DataResult;
import com.etiya.northwind.core.utilities.results.Result;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/cartdetails")
public class CartDetailsController {
    private CartDetailService cartDetailService;

    public CartDetailsController(CartDetailService cartDetailService)
    {
        this.cartDetailService=cartDetailService;
    }

    @GetMapping("/getAll")
    public DataResult<List<CartDetailListResponse>> getAll(){
        return cartDetailService.getAll();
    }

    @PostMapping("/add")
    public Result add(@RequestBody CreateCartDetailRequest createCartDetailRequest) {
        return this.cartDetailService.add(createCartDetailRequest);
    }

    @PutMapping("/update")
    public Result update(@RequestBody UpdateCartDetailRequest updateCartDetailRequest) {
        return this.cartDetailService.update(updateCartDetailRequest);
    }

    @DeleteMapping("/delete")
    public Result delete(@RequestBody DeleteCartDetailRequest deleteCartDetailRequest) {
        return this.cartDetailService.delete(deleteCartDetailRequest);
    }

    @GetMapping("/getbyid")
    public DataResult<ReadCartDetailResponse> getById(int id)
    {
        return cartDetailService.getById(id);
    }
}
