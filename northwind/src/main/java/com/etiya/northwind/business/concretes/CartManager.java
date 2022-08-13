package com.etiya.northwind.business.concretes;

import com.etiya.northwind.business.abstracts.CartDetailService;
import com.etiya.northwind.business.abstracts.CartService;
import com.etiya.northwind.business.requests.carts.CreateCartRequest;
import com.etiya.northwind.business.requests.carts.DeleteCartRequest;
import com.etiya.northwind.business.requests.carts.UpdateCartRequest;
import com.etiya.northwind.business.responses.carts.CartListResponse;
import com.etiya.northwind.business.responses.carts.ReadCartResponse;
import com.etiya.northwind.core.utilities.mapping.ModelMapperService;
import com.etiya.northwind.core.utilities.results.DataResult;
import com.etiya.northwind.core.utilities.results.Result;
import com.etiya.northwind.core.utilities.results.SuccessDataResult;
import com.etiya.northwind.core.utilities.results.SuccessResult;
import com.etiya.northwind.dataAccess.CartDetailRepository;
import com.etiya.northwind.dataAccess.CartRepository;
import com.etiya.northwind.entities.concretes.Cart;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CartManager implements CartService {
    private CartRepository cartRepository;
    private CartDetailService cartDetailService;
    private ModelMapperService modelMapperService;

    public CartManager(CartRepository cartRepository, CartDetailService cartDetailService, ModelMapperService modelMapperService) {
        this.cartRepository = cartRepository;
        this.cartDetailService = cartDetailService;
        this.modelMapperService = modelMapperService;
    }

    @Override
    public DataResult<List<CartListResponse>> getAll() {
        List<Cart> result=cartRepository.findAll();
        List<CartListResponse> response=result.stream().map(cart -> this.modelMapperService.forResponse()
                .map(cart,CartListResponse.class)).collect(Collectors.toList());

        return new SuccessDataResult<>(response);
    }

    @Override
    public Result add(CreateCartRequest createCartRequest) {
        Cart cart=modelMapperService.forRequest().map(createCartRequest, Cart.class);
        cartRepository.save(cart);
        return new SuccessResult("CART.ADDED");
    }

    @Override
    public Result update(UpdateCartRequest updateCartRequest) {
        Cart cart=modelMapperService.forRequest().map(updateCartRequest,Cart.class);
        cartRepository.save(cart);
        return new SuccessResult("CART.UPDATED");
    }

    @Override
    public Result delete(DeleteCartRequest deleteCartRequest) {
        Cart cart=modelMapperService.forRequest().map(deleteCartRequest,Cart.class);
        cartRepository.delete(cart);
        return new SuccessResult("CART.DELETED");
    }

    @Override
    public DataResult<ReadCartResponse> getById(int id) {
        Cart cart=cartRepository.findById(id).get();
        ReadCartResponse readCartResponse=modelMapperService.forResponse().map(cart,ReadCartResponse.class);
        return new SuccessDataResult<>(readCartResponse);
    }
}
