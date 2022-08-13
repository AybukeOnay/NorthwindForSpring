package com.etiya.northwind.business.responses.carts;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ReadCartResponse {

    private int cartCartId;
    private int quantity;
    private double unitPrice;
    private String companyName;
}
