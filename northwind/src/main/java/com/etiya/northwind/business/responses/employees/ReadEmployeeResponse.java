package com.etiya.northwind.business.responses.employees;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ReadEmployeeResponse {

    private int employeeId;
    private int cityId;
    private int countryId;
    private String firstName;
    private String lastName;
    private String title;
    private int reportTo;
}
