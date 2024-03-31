package com.tenth.Shopping.Service;

import com.tenth.Shopping.Entity.Orders;
import com.tenth.Shopping.Error.OrderIdNotFoundException;
import com.tenth.Shopping.Helper.EliminateColumns;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface OrdersService {
    public void save(Orders os);
    public List<EliminateColumns> allOrders();
    public List<Orders> findAllOrdersById(int orderId) throws OrderIdNotFoundException;
}
