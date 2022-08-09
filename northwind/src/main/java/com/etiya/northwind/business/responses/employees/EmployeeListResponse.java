package com.etiya.northwind.business.responses.employees;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.pl.NIP;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class EmployeeListResponse {

    private int employeeId;
    private String firstName;
    private String lastName;
    private String title;

}
