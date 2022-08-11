package com.etiya.northwind.business.requests.customers;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CreateCustomerRequest {

    @NotNull
    @NotBlank
    @Size(min = 5,max = 5)
    private String customerId;

    @NotNull
    private int cityId;

    @NotNull
    private int countryId;

    @NotNull
    @NotBlank
    private String companyName;

    @NotNull
    @NotBlank
    private String address;


}
