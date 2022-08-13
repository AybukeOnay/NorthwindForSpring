package com.etiya.northwind.business.requests.carts;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UpdateCartRequest {

    @Min(1)
    @NotNull
    private int cartId;

    @NotNull
    @Size(min = 5,max = 5)
    private String customerId;

    private int quantity;
    private double unitPrice;

}
