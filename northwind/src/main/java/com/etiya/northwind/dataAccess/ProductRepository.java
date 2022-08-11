package com.etiya.northwind.dataAccess;

import com.etiya.northwind.entities.concretes.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product,Integer> {
    List<Product> findByCategory_CategoryId(int id);
    Product findByProductName(String name);
}
