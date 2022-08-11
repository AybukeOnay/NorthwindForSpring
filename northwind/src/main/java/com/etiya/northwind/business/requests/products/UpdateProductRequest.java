package com.etiya.northwind.business.requests.products;

import javax.validation.constraints.*;

public class UpdateProductRequest {
    @NotNull
    @NotEmpty
    private int productId;

    @NotNull
    @NotBlank(message = "Product name is mandatory")
    @Size(min=1,max=15,message = "Product name must be 2 characters")
    @Pattern(regexp="(^[a-zA-Z]{2,50}$)", message = "Product name must be of characters")
    private String productName;

    @Positive(message = "Unit price must be positive value")
    private double unitPrice;

    @PositiveOrZero
    private int unitsInStock;

    @Positive
    private int categoryId;

    @NotNull
    @Min(1)
    private int supplierId;
}
