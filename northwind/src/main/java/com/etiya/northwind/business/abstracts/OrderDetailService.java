package com.etiya.northwind.business.abstracts;

import com.etiya.northwind.business.requests.orderDetails.CreateOrderDetailRequest;
import com.etiya.northwind.business.requests.orderDetails.DeleteOrderDetailRequest;
import com.etiya.northwind.business.requests.orderDetails.UpdateOrderDetailRequest;
import com.etiya.northwind.business.responses.orderDetails.OrderDetailListResponse;
import com.etiya.northwind.business.responses.orderDetails.ReadOrderDetailResponse;
import com.etiya.northwind.core.utilities.results.DataResult;
import com.etiya.northwind.core.utilities.results.Result;

import java.util.List;

public interface OrderDetailService {
    DataResult<List<OrderDetailListResponse>> getAll();
    Result add(CreateOrderDetailRequest createOrderDetailRequest);
    Result update(UpdateOrderDetailRequest updateOrderDetailRequest);
    Result delete(DeleteOrderDetailRequest deleteOrderDetailRequest);
    DataResult<ReadOrderDetailResponse> getById(int orderId, int productId);

}
