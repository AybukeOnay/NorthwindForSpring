package com.etiya.northwind.business.concretes;

import com.etiya.northwind.business.abstracts.OrderService;
import com.etiya.northwind.business.responses.orders.OrderListResponse;
import com.etiya.northwind.core.utilities.mapping.ModelMapperService;
import com.etiya.northwind.dataAccess.OrderRepository;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import java.util.List;

@Service
public class OrderManager implements OrderService {
    private OrderRepository orderRepository;
    private ModelMapperService modelMapperService;

    public OrderManager(OrderRepository orderRepository, ModelMapperService modelMapperService) {
        this.orderRepository = orderRepository;
        this.modelMapperService = modelMapperService;
    }

    @Override
    public List<OrderListResponse> getAll() {
        return null;
    }
}
