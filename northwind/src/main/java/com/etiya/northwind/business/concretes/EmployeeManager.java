package com.etiya.northwind.business.concretes;

import com.etiya.northwind.business.abstracts.EmployeeService;
import com.etiya.northwind.business.requests.employees.CreateEmployeeRequest;
import com.etiya.northwind.business.requests.employees.DeleteEmployeeRequest;
import com.etiya.northwind.business.requests.employees.UpdateEmployeeRequest;
import com.etiya.northwind.business.responses.customers.CustomerListResponse;
import com.etiya.northwind.business.responses.employees.EmployeeListResponse;
import com.etiya.northwind.business.responses.employees.ReadEmployeeResponse;
import com.etiya.northwind.business.responses.products.ProductListResponse;
import com.etiya.northwind.core.utilities.exceptions.BusinessException;
import com.etiya.northwind.core.utilities.mapping.ModelMapperService;
import com.etiya.northwind.core.utilities.results.DataResult;
import com.etiya.northwind.core.utilities.results.Result;
import com.etiya.northwind.core.utilities.results.SuccessDataResult;
import com.etiya.northwind.core.utilities.results.SuccessResult;
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
    public DataResult<List<EmployeeListResponse>> getAll() {
        List<Employee> results = employeeRepository.findAll();
        List<EmployeeListResponse> response = results.stream().map(employee -> this.modelMapperService.forResponse().map(employee,EmployeeListResponse.class)).collect(Collectors.toList());
        return new SuccessDataResult<List<EmployeeListResponse>>(response);
    }

    @Override
    public Result add(CreateEmployeeRequest createEmployeeRequest) {
        checkIfReportLimitExceeds(createEmployeeRequest.getReportTo());
        Employee employee = this.modelMapperService.forRequest().map(createEmployeeRequest,Employee.class);
        this.employeeRepository.save(employee);
        return new SuccessResult("EMPLOYEE.ADDED");
    }

    @Override
    public Result update(UpdateEmployeeRequest updateEmployeeRequest) {
        Employee employee = this.modelMapperService.forRequest().map(updateEmployeeRequest,Employee.class);
        this.employeeRepository.save(employee);
        return new SuccessResult("EMPLOYEE.UPDATED");
    }

    @Override
    public Result delete(DeleteEmployeeRequest deleteEmployeeRequest) {
        Employee employee = this.modelMapperService.forRequest().map(deleteEmployeeRequest,Employee.class);
        this.employeeRepository.delete(employee);
        return new SuccessResult("EMPLOYEE.DELETED");
    }

    @Override
    public DataResult<ReadEmployeeResponse> getById(int id) {
        Employee employee = this.employeeRepository.findById(id).get();
        ReadEmployeeResponse response = this.modelMapperService.forRequest().map(employee, ReadEmployeeResponse.class);

        return new SuccessDataResult<ReadEmployeeResponse>(response);
    }

    private void checkIfReportLimitExceeds(Integer reportId)  {
        List<Employee> employees = this.employeeRepository.findByReportTo(reportId);
        if (employees.size() > 10){
            throw new BusinessException("Report limit is exceeded");
        }
    }
}
