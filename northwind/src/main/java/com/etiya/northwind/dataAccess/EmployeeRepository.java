package com.etiya.northwind.dataAccess;

import com.etiya.northwind.entities.concretes.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface EmployeeRepository extends JpaRepository<Employee,Integer> {

    List<Employee> findByReportTo(Integer reportId);
}
