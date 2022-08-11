package com.etiya.northwind.business.requests.suppliers;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CreateSupplierRequest {

    @NotNull
    @Min(1)
    private int supplierId;

    @NotNull
    private int cityId;

    @NotNull
    private int countryId;

    @NotNull
    @NotBlank
    @Size(min=2 ,message = "Company Name must be 2  characters")
    private String companyName;

    @NotNull
    @NotBlank
    private String address;


}
