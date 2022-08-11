package com.etiya.northwind.business.responses.suppliers;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class SupplierListResponse {

    private int supplierId;
    private int productId;
    private int cityId;
    private int countryId;
    private String companyName;
    private String address;

}
