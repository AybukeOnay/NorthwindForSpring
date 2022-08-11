package com.etiya.northwind.dataAccess;

import com.etiya.northwind.entities.concretes.OrderDetail;
import com.etiya.northwind.entities.concretes.OrderDetailId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

public interface OrderDetailRepository extends JpaRepository<OrderDetail, OrderDetailId> {
    @Transactional
    @Modifying
    @Query("Delete From OrderDetail  Where order_id =:orderId and product_id =:productId")
    void deleteOrderDetailWithOrderIdAndProductId(@Param("orderId")int orderId,@Param("productId")int productId);

    OrderDetail getByOrder_OrderIdAndProduct_ProductId( int orderId,int productId);
}
