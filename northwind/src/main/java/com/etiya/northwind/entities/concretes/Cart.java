package com.etiya.northwind.entities.concretes;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="carts")
public class Cart {

    @Id
    @Column(name = "cart_id")
    private int cartId;

    @Column(name = "quantity")
    private int quantity;

    @Column(name = "unit_price")
    private double unitPrice;

    @OneToOne
    @JoinColumn(name="customer_id",unique = true)
    private Customer customer;

    @OneToMany(mappedBy = "cart")
    private List<CartDetail> cartDetails;



}
