package com.etiya.northwind.business.concretes;

import com.etiya.northwind.business.abstracts.SupplierService;
import com.etiya.northwind.business.responses.customers.CustomerListResponse;
import com.etiya.northwind.business.responses.suppliers.SupplierListResponse;
import com.etiya.northwind.core.utilities.mapping.ModelMapperService;
import com.etiya.northwind.dataAccess.SupplierRepository;
import com.etiya.northwind.entities.concretes.Customer;
import com.etiya.northwind.entities.concretes.Supplier;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class SupplierManager implements SupplierService {
    private SupplierRepository supplierRepository;
    private ModelMapperService modelMapperService;

    public SupplierManager(SupplierRepository supplierRepository, ModelMapperService modelMapperService) {
        this.supplierRepository = supplierRepository;
        this.modelMapperService = modelMapperService;
    }

    @Override
    public List<SupplierListResponse> getAll() {
        List<Supplier> results = supplierRepository.findAll();
        List<SupplierListResponse> responses = results.stream().map(supplier -> this.modelMapperService.forResponse().map(supplier,SupplierListResponse.class)).collect(Collectors.toList());
        return responses;
    }
}
