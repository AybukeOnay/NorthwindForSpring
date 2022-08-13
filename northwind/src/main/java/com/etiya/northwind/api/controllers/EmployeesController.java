package com.etiya.northwind.api.controllers;

import com.etiya.northwind.business.abstracts.EmployeeService;
import com.etiya.northwind.business.requests.employees.CreateEmployeeRequest;
import com.etiya.northwind.business.requests.employees.DeleteEmployeeRequest;
import com.etiya.northwind.business.requests.employees.UpdateEmployeeRequest;
import com.etiya.northwind.business.responses.employees.EmployeeListResponse;
import com.etiya.northwind.business.responses.employees.ReadEmployeeResponse;
import com.etiya.northwind.core.utilities.results.DataResult;
import com.etiya.northwind.core.utilities.results.Result;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/employees")
public class EmployeesController {
    private EmployeeService employeeService;

    public EmployeesController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping("/getall")
    public DataResult<List<EmployeeListResponse>> getAll()
    {
        return employeeService.getAll();
    }

    @GetMapping("/getbyid")
    public DataResult<ReadEmployeeResponse> getById(int id)
    {
        return employeeService.getById(id);
    }

    @PostMapping("/add")
    public Result add(@RequestBody @Valid CreateEmployeeRequest createEmployeeRequest){
        return this.employeeService.add(createEmployeeRequest);
    }

    @PutMapping("/update")
    public Result update(@RequestBody @Valid UpdateEmployeeRequest updateEmployeeRequest){
        return this.employeeService.update(updateEmployeeRequest);
    }

    @DeleteMapping("/delete")
    public Result delete(DeleteEmployeeRequest deleteEmployeeRequest){
        return this.employeeService.delete(deleteEmployeeRequest);
    }
}
