package com.etiya.northwind.dataAccess;

import com.etiya.northwind.entities.concretes.Cart;
import com.etiya.northwind.entities.concretes.CartDetail;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CartRepository extends JpaRepository<Cart,Integer> {
}
