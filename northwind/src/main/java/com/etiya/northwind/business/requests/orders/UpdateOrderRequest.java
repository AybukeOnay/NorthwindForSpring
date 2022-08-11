package com.etiya.northwind.business.requests.orders;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UpdateOrderRequest {
    @NotNull
    @Min(1)
    private int orderId;

    @NotBlank
    @NotNull
    @Size(min=5, max=5 ,message="Id must contain 5 characters")
    @Pattern(regexp="(^[a-zA-Z]{5}$)", message = "Customer id must be of characters")
    private String customerId;

    @NotNull
    @Min(1)
    private int employeeId;
}
