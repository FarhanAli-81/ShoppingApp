package com.tenth.Shopping.Repository;

import com.tenth.Shopping.Entity.Orders;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface OrdersRepository extends JpaRepository<Orders, String> {
    public List<Orders> findByOrderId(int orderId);
}
