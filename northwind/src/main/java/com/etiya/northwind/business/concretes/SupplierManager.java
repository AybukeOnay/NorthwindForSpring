package com.etiya.northwind.business.concretes;

import com.etiya.northwind.business.abstracts.SupplierService;
import com.etiya.northwind.business.requests.suppliers.CreateSupplierRequest;
import com.etiya.northwind.business.requests.suppliers.DeleteSupplierRequest;
import com.etiya.northwind.business.requests.suppliers.UpdateSupplierRequest;
import com.etiya.northwind.business.responses.customers.CustomerListResponse;
import com.etiya.northwind.business.responses.employees.ReadEmployeeResponse;
import com.etiya.northwind.business.responses.products.ProductListResponse;
import com.etiya.northwind.business.responses.suppliers.ReadSupplierResponse;
import com.etiya.northwind.business.responses.suppliers.SupplierListResponse;
import com.etiya.northwind.core.utilities.mapping.ModelMapperService;
import com.etiya.northwind.core.utilities.results.DataResult;
import com.etiya.northwind.core.utilities.results.Result;
import com.etiya.northwind.core.utilities.results.SuccessDataResult;
import com.etiya.northwind.core.utilities.results.SuccessResult;
import com.etiya.northwind.dataAccess.SupplierRepository;
import com.etiya.northwind.entities.concretes.Customer;
import com.etiya.northwind.entities.concretes.Employee;
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
    public DataResult<List<SupplierListResponse>> getAll() {
        List<Supplier> results = supplierRepository.findAll();
        List<SupplierListResponse> response = results.stream().map(supplier -> this.modelMapperService.forResponse().map(supplier,SupplierListResponse.class)).collect(Collectors.toList());
        return new SuccessDataResult<List<SupplierListResponse>>(response);
    }

    @Override
    public Result add(CreateSupplierRequest createSupplierRequest) {
        Supplier supplier = this.modelMapperService.forRequest().map(createSupplierRequest,Supplier.class);
        this.supplierRepository.save(supplier);
        return new SuccessResult("SUPPLIER.ADDED");
    }

    @Override
    public Result update(UpdateSupplierRequest updateSupplierRequest) {
        Supplier supplier = this.modelMapperService.forRequest().map(updateSupplierRequest,Supplier.class);
        this.supplierRepository.save(supplier);
        return new SuccessResult("SUPPLIER.UPDATED");
    }

    @Override
    public Result delete(DeleteSupplierRequest deleteSupplierRequest) {
        Supplier supplier = this.modelMapperService.forRequest().map(deleteSupplierRequest,Supplier.class);
        this.supplierRepository.delete(supplier);
        return new SuccessResult("SUPPLIER.DELETED");
    }

    @Override
    public DataResult<ReadSupplierResponse> getById(int id) {
        Supplier supplier = this.supplierRepository.findById(id).get();
        ReadSupplierResponse response = this.modelMapperService.forRequest().map(supplier, ReadSupplierResponse.class);

        return new SuccessDataResult<ReadSupplierResponse>(response);
    }
}
