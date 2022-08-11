package com.etiya.northwind.business.concretes;

import com.etiya.northwind.business.abstracts.OrderDetailService;
import com.etiya.northwind.business.requests.orderDetails.CreateOrderDetailRequest;
import com.etiya.northwind.business.requests.orderDetails.DeleteOrderDetailRequest;
import com.etiya.northwind.business.requests.orderDetails.UpdateOrderDetailRequest;
import com.etiya.northwind.business.responses.customers.CustomerListResponse;
import com.etiya.northwind.business.responses.customers.ReadCustomerResponse;
import com.etiya.northwind.business.responses.orderDetails.OrderDetailListResponse;
import com.etiya.northwind.business.responses.orderDetails.ReadOrderDetailResponse;
import com.etiya.northwind.core.utilities.mapping.ModelMapperService;
import com.etiya.northwind.core.utilities.results.DataResult;
import com.etiya.northwind.core.utilities.results.Result;
import com.etiya.northwind.core.utilities.results.SuccessDataResult;
import com.etiya.northwind.core.utilities.results.SuccessResult;
import com.etiya.northwind.dataAccess.OrderDetailRepository;
import com.etiya.northwind.entities.concretes.Customer;
import com.etiya.northwind.entities.concretes.OrderDetail;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class OrderDetailManager implements OrderDetailService {
    private OrderDetailRepository orderDetailRepository;
    private ModelMapperService modelMapperService;

    public OrderDetailManager(OrderDetailRepository orderDetailRepository, ModelMapperService modelMapperService) {
        this.orderDetailRepository = orderDetailRepository;
        this.modelMapperService = modelMapperService;
    }

    @Override
    public DataResult<List<OrderDetailListResponse>> getAll() {
        List<OrderDetail> results = orderDetailRepository.findAll();
        List<OrderDetailListResponse> response = results.stream().map(orderDetail -> this.modelMapperService.forResponse().map(orderDetail,OrderDetailListResponse.class)).collect(Collectors.toList());
        return new SuccessDataResult<>(response);
    }

    @Override
    public Result add(CreateOrderDetailRequest createOrderDetailRequest) {
        OrderDetail orderDetail = this.modelMapperService.forRequest().map(createOrderDetailRequest, OrderDetail.class);
        this.orderDetailRepository.save(orderDetail);
        return new SuccessResult("ORDER.DETAIL.ADDED");
    }

    @Override
    public Result update(UpdateOrderDetailRequest updateOrderDetailRequest) {
        OrderDetail orderDetail = this.modelMapperService.forRequest().map(updateOrderDetailRequest, OrderDetail.class);
        this.orderDetailRepository.save(orderDetail);
        return new SuccessResult("ORDER.DETAIL.UPDATED");
    }

    @Override
    public Result delete(DeleteOrderDetailRequest deleteOrderDetailRequest) {
        this.orderDetailRepository.deleteOrderDetailWithOrderIdAndProductId(deleteOrderDetailRequest.getOrderId(), deleteOrderDetailRequest.getProductId());
        return new SuccessResult("ORDER.DETAIL.DELETED");
    }

    @Override
    public DataResult<ReadOrderDetailResponse> getById(int orderId, int productId) {
        OrderDetail orderDetail = this.orderDetailRepository.getByOrder_OrderIdAndProduct_ProductId(orderId,productId);
        ReadOrderDetailResponse response = this.modelMapperService.forResponse().map(orderDetail, ReadOrderDetailResponse.class);
        return new SuccessDataResult<>(response);
    }
}
