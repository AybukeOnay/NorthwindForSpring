package com.etiya.northwind.business.abstracts;

import com.etiya.northwind.business.requests.orders.CreateOrderRequest;
import com.etiya.northwind.business.requests.orders.DeleteOrderRequest;
import com.etiya.northwind.business.requests.orders.UpdateOrderRequest;
import com.etiya.northwind.business.responses.orders.OrderListResponse;
import com.etiya.northwind.business.responses.orders.ReadOrderResponse;
import com.etiya.northwind.core.utilities.results.DataResult;
import com.etiya.northwind.core.utilities.results.Result;
import com.etiya.northwind.entities.concretes.Order;

import java.util.List;

public interface OrderService {
    DataResult<List<OrderListResponse>> getAll();
    Result add(CreateOrderRequest createOrderRequest);
    Result update(UpdateOrderRequest updateOrderRequest);
    Result delete(DeleteOrderRequest deleteOrderRequest);
    DataResult<ReadOrderResponse> getById(int id);
    Order getByOrderId(int id);


}
