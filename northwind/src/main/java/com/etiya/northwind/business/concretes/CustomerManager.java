package com.etiya.northwind.business.concretes;

import com.etiya.northwind.business.abstracts.CustomerService;
import com.etiya.northwind.business.requests.customers.CreateCustomerRequest;
import com.etiya.northwind.business.requests.customers.DeleteCustomerRequest;
import com.etiya.northwind.business.requests.customers.UpdateCustomerRequest;
import com.etiya.northwind.business.responses.customers.CustomerListResponse;
import com.etiya.northwind.business.responses.customers.ReadCustomerResponse;
import com.etiya.northwind.business.responses.products.ProductListResponse;
import com.etiya.northwind.business.responses.suppliers.ReadSupplierResponse;
import com.etiya.northwind.core.utilities.mapping.ModelMapperService;
import com.etiya.northwind.core.utilities.results.DataResult;
import com.etiya.northwind.core.utilities.results.Result;
import com.etiya.northwind.core.utilities.results.SuccessDataResult;
import com.etiya.northwind.core.utilities.results.SuccessResult;
import com.etiya.northwind.dataAccess.CustomerRepository;
import com.etiya.northwind.entities.concretes.Customer;
import com.etiya.northwind.entities.concretes.Supplier;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CustomerManager implements CustomerService {
    private CustomerRepository customerRepository;
    private ModelMapperService modelMapperService;

    public CustomerManager(CustomerRepository customerRepository, ModelMapperService modelModelMapperService) {
        this.customerRepository = customerRepository;
        this.modelMapperService = modelModelMapperService;
    }

    @Override
    public DataResult<List<CustomerListResponse>> getAll() {
        List<Customer> results = customerRepository.findAll();
        List<CustomerListResponse> response = results.stream().map(customer -> this.modelMapperService.forResponse().map(customer,CustomerListResponse.class)).collect(Collectors.toList());
        return new SuccessDataResult<List<CustomerListResponse>>(response);
    }

    @Override
    public Result add(CreateCustomerRequest createCustomerRequest) {
        Customer customer = this.modelMapperService.forRequest().map(createCustomerRequest,Customer.class);
        this.customerRepository.save(customer);
        return new SuccessResult("CUSTOMER.ADDED");
    }

    @Override
    public Result update(UpdateCustomerRequest updateCustomerRequest) {
        Customer customer = this.modelMapperService.forRequest().map(updateCustomerRequest,Customer.class);
        this.customerRepository.save(customer);
        return new SuccessResult("CUSTOMER.UPDATED");
    }

    @Override
    public Result delete(DeleteCustomerRequest deleteCustomerRequest) {
        Customer customer = this.modelMapperService.forRequest().map(deleteCustomerRequest,Customer.class);
        this.customerRepository.delete(customer);
        return new SuccessResult("CUSTOMER.DELETED");
    }

    @Override
    public DataResult<ReadCustomerResponse> getById(String id) {
        Customer customer = this.customerRepository.findById(id).get();
        ReadCustomerResponse response = this.modelMapperService.forRequest().map(customer, ReadCustomerResponse.class);

        return new SuccessDataResult<ReadCustomerResponse>(response);
    }
}
