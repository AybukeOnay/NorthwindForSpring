package com.etiya.northwind.business.requests.orderDetails;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import javax.validation.constraints.PositiveOrZero;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CreateOrderDetailRequest {

    @NotNull
    @Min(1)
    private int orderId;

    @NotNull
    @Min(1)
    private int productId;

    @NotNull
    @Positive
    private int quantity;

    @NotNull
    @PositiveOrZero
    private double discount;

    @NotNull
    @Positive
    private double unitPrice;
}
