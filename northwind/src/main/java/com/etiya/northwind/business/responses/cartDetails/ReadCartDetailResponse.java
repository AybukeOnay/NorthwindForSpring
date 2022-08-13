package com.etiya.northwind.business.responses.cartDetails;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ReadCartDetailResponse {
    private int cartDetailId;
    private int cartCartId;
    private int productId;
    private String productName;
}
