package com.etiya.northwind.dataAccess;

import com.etiya.northwind.entities.concretes.OrderDetail;
import com.etiya.northwind.entities.concretes.OrderDetailId;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderDetailRepository extends JpaRepository<OrderDetail, OrderDetailId> {
}
