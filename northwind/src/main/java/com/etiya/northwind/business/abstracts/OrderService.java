package com.etiya.northwind.business.abstracts;

import com.etiya.northwind.business.responses.orders.OrderListResponse;

import java.util.List;

public interface OrderService {
    List<OrderListResponse> getAll();
}
