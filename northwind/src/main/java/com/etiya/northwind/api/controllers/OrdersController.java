package com.etiya.northwind.api.controllers;

import com.etiya.northwind.business.abstracts.OrderService;
import com.etiya.northwind.business.requests.orders.CreateOrderRequest;
import com.etiya.northwind.business.requests.orders.DeleteOrderRequest;
import com.etiya.northwind.business.requests.orders.UpdateOrderRequest;
import com.etiya.northwind.business.responses.categories.CategoryListResponse;
import com.etiya.northwind.business.responses.employees.ReadEmployeeResponse;
import com.etiya.northwind.business.responses.orders.OrderListResponse;
import com.etiya.northwind.business.responses.orders.ReadOrderResponse;
import com.etiya.northwind.core.utilities.results.DataResult;
import com.etiya.northwind.core.utilities.results.Result;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/orders")
public class OrdersController {
    private OrderService orderService;

    public OrdersController(OrderService orderService) {
        this.orderService = orderService;
    }

    @GetMapping("/getAll")
    public DataResult<List<OrderListResponse>> getAll(){
        return orderService.getAll();
    }

    @GetMapping("/getbyid")
    public DataResult<ReadOrderResponse> getById(int id)
    {
        return orderService.getById(id);
    }

    @PostMapping("/add")
    public Result add(@RequestBody @Valid CreateOrderRequest createOrderRequest){
       return this.orderService.add(createOrderRequest);
    }

    @PutMapping("/update")
    public Result update(@RequestBody @Valid UpdateOrderRequest updateOrderRequest){
        return this.orderService.update(updateOrderRequest);
    }

    @DeleteMapping("/delete")
    public Result delete(@RequestBody DeleteOrderRequest deleteOrderRequest){
        return this.orderService.delete(deleteOrderRequest);
    }
}
