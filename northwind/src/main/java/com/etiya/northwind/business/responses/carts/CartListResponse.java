package com.etiya.northwind.business.responses.carts;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CartListResponse {

    private int cartCartId;
    private String customerId;
    private int quantity;
    private double unitPrice;
}
