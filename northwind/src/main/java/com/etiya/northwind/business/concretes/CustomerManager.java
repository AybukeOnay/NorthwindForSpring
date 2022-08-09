package com.etiya.northwind.business.concretes;

import com.etiya.northwind.business.abstracts.CustomerService;
import com.etiya.northwind.business.responses.customers.CustomerListResponse;
import com.etiya.northwind.core.utilities.mapping.ModelMapperService;
import com.etiya.northwind.dataAccess.CustomerRepository;
import com.etiya.northwind.entities.concretes.Customer;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CustomerManager implements CustomerService {
    private CustomerRepository customerRepository;
    private ModelMapperService modelModelMapperService;

    public CustomerManager(CustomerRepository customerRepository, ModelMapperService modelModelMapperService) {
        this.customerRepository = customerRepository;
        this.modelModelMapperService = modelModelMapperService;
    }

    @Override
    public List<CustomerListResponse> getAll() {
        List<Customer> results = customerRepository.findAll();
        List<CustomerListResponse> responses = results.stream().map(customer -> this.modelModelMapperService.forResponse().map(customer,CustomerListResponse.class)).collect(Collectors.toList());
        return responses;
    }
}
