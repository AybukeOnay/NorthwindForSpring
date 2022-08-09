package com.etiya.northwind.business.concretes;

import com.etiya.northwind.business.abstracts.OrderDetailService;
import com.etiya.northwind.business.responses.customers.CustomerListResponse;
import com.etiya.northwind.business.responses.orderDetails.OrderDetailListResponse;
import com.etiya.northwind.core.utilities.mapping.ModelMapperService;
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
    public List<OrderDetailListResponse> getAll() {
        List<OrderDetail> results = orderDetailRepository.findAll();
        List<OrderDetailListResponse> responses = results.stream().map(orderDetail -> this.modelMapperService.forResponse().map(orderDetail,OrderDetailListResponse.class)).collect(Collectors.toList());
        return responses;
    }
}
