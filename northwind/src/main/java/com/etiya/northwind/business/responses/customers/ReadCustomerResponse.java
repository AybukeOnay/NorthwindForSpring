package com.etiya.northwind.business.responses.customers;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ReadCustomerResponse {
    private String customerId;
    private int cityId;
    private int countryId;
    private String companyName;
    private String address;

}
