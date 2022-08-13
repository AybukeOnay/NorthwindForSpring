package com.etiya.northwind.business.concretes;

import com.etiya.northwind.business.abstracts.CartDetailService;
import com.etiya.northwind.business.requests.cartDetails.CreateCartDetailRequest;
import com.etiya.northwind.business.requests.cartDetails.DeleteCartDetailRequest;
import com.etiya.northwind.business.requests.cartDetails.UpdateCartDetailRequest;
import com.etiya.northwind.business.responses.cartDetails.CartDetailListResponse;
import com.etiya.northwind.business.responses.cartDetails.ReadCartDetailResponse;
import com.etiya.northwind.business.responses.carts.CartListResponse;
import com.etiya.northwind.core.utilities.mapping.ModelMapperService;
import com.etiya.northwind.core.utilities.results.DataResult;
import com.etiya.northwind.core.utilities.results.Result;
import com.etiya.northwind.core.utilities.results.SuccessDataResult;
import com.etiya.northwind.core.utilities.results.SuccessResult;
import com.etiya.northwind.dataAccess.CartDetailRepository;
import com.etiya.northwind.entities.concretes.Cart;
import com.etiya.northwind.entities.concretes.CartDetail;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class CartDetailManager implements CartDetailService {
    private CartDetailRepository cartDetailRepository;
    private ModelMapperService modelMapperService;

    public CartDetailManager(CartDetailRepository cartDetailRepository, ModelMapperService modelMapperService) {
        this.cartDetailRepository = cartDetailRepository;
        this.modelMapperService = modelMapperService;
    }

    @Override
    public DataResult<List<CartDetailListResponse>> getAll() {

        List<CartDetail> result=cartDetailRepository.findAll();
        List<CartDetailListResponse> response=result.stream().map(cartDetail -> this.modelMapperService.forResponse()
                .map(cartDetail,CartDetailListResponse.class)).collect(Collectors.toList());

        return new SuccessDataResult<>(response);

    }

    @Override
    public Result add(CreateCartDetailRequest createCartDetailRequest) {
        CartDetail cartDetail=modelMapperService.forRequest().map(createCartDetailRequest,CartDetail.class);
        cartDetailRepository.save(cartDetail);

        return new SuccessResult("CART.DETAIL.ADDED");
    }

    @Override
    public Result update(UpdateCartDetailRequest updateCartDetailRequest) {
        CartDetail cartDetail=modelMapperService.forRequest().map(updateCartDetailRequest,CartDetail.class);
        cartDetailRepository.save(cartDetail);

        return new SuccessResult("CART.DETAIL.UPDATED");
    }

    @Override
    public Result delete(DeleteCartDetailRequest deleteCartDetailRequest) {
        CartDetail cartDetail=modelMapperService.forRequest().map(deleteCartDetailRequest,CartDetail.class);
        cartDetailRepository.delete(cartDetail);
        return new SuccessResult("CART.DETAIL.DELETED");
    }

    @Override
    public DataResult<ReadCartDetailResponse> getById(int id) {
        CartDetail cartDetail=cartDetailRepository.findById(id).get();
        ReadCartDetailResponse readCartDetailResponse=modelMapperService.forResponse().map(cartDetail,ReadCartDetailResponse.class);
        return new SuccessDataResult<>(readCartDetailResponse);
    }
}
