package com.etiya.northwind.business.requests.cartDetails;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DeleteCartDetailRequest {

    @NotNull
    @Min(1)
    private int cartDetailId;
}
