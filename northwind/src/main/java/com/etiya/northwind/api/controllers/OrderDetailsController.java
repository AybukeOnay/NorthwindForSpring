package com.etiya.northwind.api.controllers;

import com.etiya.northwind.business.abstracts.OrderDetailService;
import com.etiya.northwind.business.responses.orderDetails.OrderDetailListResponse;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/orderdetails")
public class OrderDetailsController {
    private OrderDetailService orderDetailService;

    public OrderDetailsController(OrderDetailService orderDetailService) {
        this.orderDetailService = orderDetailService;
    }

    public List<OrderDetailListResponse> getAll(){
        return orderDetailService.getAll();
    }
}
