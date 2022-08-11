package com.etiya.northwind.business.concretes;

import com.etiya.northwind.business.abstracts.OrderService;
import com.etiya.northwind.business.requests.orders.CreateOrderRequest;
import com.etiya.northwind.business.requests.orders.DeleteOrderRequest;
import com.etiya.northwind.business.requests.orders.UpdateOrderRequest;
import com.etiya.northwind.business.responses.employees.ReadEmployeeResponse;
import com.etiya.northwind.business.responses.orders.OrderListResponse;
import com.etiya.northwind.business.responses.orders.ReadOrderResponse;
import com.etiya.northwind.business.responses.products.ProductListResponse;
import com.etiya.northwind.core.utilities.mapping.ModelMapperService;
import com.etiya.northwind.core.utilities.results.DataResult;
import com.etiya.northwind.core.utilities.results.Result;
import com.etiya.northwind.core.utilities.results.SuccessDataResult;
import com.etiya.northwind.core.utilities.results.SuccessResult;
import com.etiya.northwind.dataAccess.OrderRepository;
import com.etiya.northwind.entities.concretes.Order;
import com.etiya.northwind.entities.concretes.Product;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class OrderManager implements OrderService {
    private OrderRepository orderRepository;
    private ModelMapperService modelMapperService;

    public OrderManager(OrderRepository orderRepository, ModelMapperService modelMapperService) {
        this.orderRepository = orderRepository;
        this.modelMapperService = modelMapperService;
    }

    @Override
    public DataResult<List<OrderListResponse>> getAll() {

        List<Order> result = orderRepository.findAll();
        List<OrderListResponse> response = result.stream().map(order ->  this.modelMapperService.forResponse().map(order,OrderListResponse.class)).collect(Collectors.toList());
        return new SuccessDataResult<List<OrderListResponse>>(response);
    }

    @Override
    public Result add(CreateOrderRequest createOrderRequest) {
        Order order = this.modelMapperService.forRequest().map(createOrderRequest,Order.class);
        this.orderRepository.save(order);
        return new SuccessResult("ORDER.ADDED");
    }

    @Override
    public Result update(UpdateOrderRequest updateOrderRequest) {
        Order order = this.modelMapperService.forRequest().map(updateOrderRequest,Order.class);
        this.orderRepository.save(order);
        return new SuccessResult("ORDER.UPDATED");
    }

    @Override
    public Result delete(DeleteOrderRequest deleteOrderRequest) {
        Order order = this.modelMapperService.forRequest().map(deleteOrderRequest,Order.class);
        this.orderRepository.delete(order);

        return new SuccessResult("ORDER.DELETED");
    }

    @Override
    public DataResult<ReadOrderResponse> getById(int id) {
        Order order = this.orderRepository.findById(id).get();
        ReadOrderResponse response = this.modelMapperService.forResponse().map(order, ReadOrderResponse.class);

        return new SuccessDataResult<ReadOrderResponse>(response);
    }

    @Override
    public Order getByOrderId(int id) {
        Order order = this.orderRepository.findById(id).get();
        return order;
    }
}
