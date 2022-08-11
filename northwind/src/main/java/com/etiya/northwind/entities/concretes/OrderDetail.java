package com.etiya.northwind.entities.concretes;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@IdClass(OrderDetailId.class)
@Table(name="order_details")
public class OrderDetail implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name="order_id")
    private int orderId;

    @ManyToOne
    @JoinColumn(name="order_id",insertable = false, updatable = false)
    private Order order;

    @Id
    @Column(name="product_id")
    private int productId;

    @ManyToOne
    @JoinColumn(name="product_id",insertable = false, updatable = false)
    private Product product;

    @Column(name = "quantity")
    private int quantity;

    @Column(name = "discount")
    private double discount;

    @Column(name = "unit_price")
    private double unitPrice;






}
