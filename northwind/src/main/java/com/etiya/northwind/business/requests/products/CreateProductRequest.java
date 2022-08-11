package com.etiya.northwind.business.requests.products;

import com.etiya.northwind.entities.concretes.Category;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateProductRequest {

    @NotNull
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
