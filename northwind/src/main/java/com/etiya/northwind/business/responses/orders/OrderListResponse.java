package com.etiya.northwind.business.responses.orders;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class OrderListResponse {
    private int orderId;
    private String companyName;
    private String firstName;
    private String lastName;
}
