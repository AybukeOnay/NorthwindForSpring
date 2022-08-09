package com.etiya.northwind.business.abstracts;

import com.etiya.northwind.business.responses.employees.EmployeeListResponse;

import java.util.List;

public interface EmployeeService {
    List<EmployeeListResponse> getAll();
}
