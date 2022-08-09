package com.etiya.northwind.dataAccess;

import com.etiya.northwind.entities.concretes.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category,Integer> {
}
