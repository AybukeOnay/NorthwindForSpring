package com.etiya.northwind.business.concretes;

import com.etiya.northwind.business.abstracts.EmployeeService;
import com.etiya.northwind.business.responses.customers.CustomerListResponse;
import com.etiya.northwind.business.responses.employees.EmployeeListResponse;
import com.etiya.northwind.core.utilities.mapping.ModelMapperService;
import com.etiya.northwind.dataAccess.EmployeeRepository;
import com.etiya.northwind.entities.concretes.Employee;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class EmployeeManager implements EmployeeService {
    private EmployeeRepository employeeRepository;
    private ModelMapperService modelMapperService;

    public EmployeeManager(EmployeeRepository employeeRepository, ModelMapperService modelMapperService) {
        this.employeeRepository = employeeRepository;
        this.modelMapperService = modelMapperService;
    }

    @Override
    public List<EmployeeListResponse> getAll() {
        List<Employee> results = employeeRepository.findAll();
        List<EmployeeListResponse> responses = results.stream().map(employee -> this.modelMapperService.forResponse().map(employee,EmployeeListResponse.class)).collect(Collectors.toList());
        return responses;
    }
}
