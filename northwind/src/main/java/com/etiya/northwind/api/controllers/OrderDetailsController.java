package com.etiya.northwind.api.controllers;

import com.etiya.northwind.business.abstracts.OrderDetailService;
import com.etiya.northwind.business.requests.orderDetails.CreateOrderDetailRequest;
import com.etiya.northwind.business.requests.orderDetails.DeleteOrderDetailRequest;
import com.etiya.northwind.business.requests.orderDetails.UpdateOrderDetailRequest;
import com.etiya.northwind.business.responses.orderDetails.OrderDetailListResponse;
import com.etiya.northwind.business.responses.orderDetails.ReadOrderDetailResponse;
import com.etiya.northwind.core.utilities.results.DataResult;
import com.etiya.northwind.core.utilities.results.Result;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/orderdetails")
public class OrderDetailsController {
    private OrderDetailService orderDetailService;

    public OrderDetailsController(OrderDetailService orderDetailService) {
        this.orderDetailService = orderDetailService;
    }
    @GetMapping("/getall")
    public DataResult<List<OrderDetailListResponse>> getAll(){
        return orderDetailService.getAll();
    }

    @GetMapping("/getbyid")
    public DataResult<ReadOrderDetailResponse> getById(@RequestParam int orderId,@RequestParam int productId)
    {
        return this.orderDetailService.getById(orderId,productId);
    }

    @PostMapping("/add")
    public Result add(@RequestBody @Valid CreateOrderDetailRequest createOrderDetailRequest) {
        return this.orderDetailService.add(createOrderDetailRequest);
    }

    @PutMapping("/update")
    public Result update(@RequestBody @Valid UpdateOrderDetailRequest updateOrderDetailRequest) {
        return this.orderDetailService.update(updateOrderDetailRequest);
    }

    @DeleteMapping("/delete")
    public Result delete(@RequestBody @Valid DeleteOrderDetailRequest deleteOrderDetailRequest) {
        return this.orderDetailService.delete(deleteOrderDetailRequest);
    }
}
