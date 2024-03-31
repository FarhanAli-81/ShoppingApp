package com.tenth.Shopping.Service;

import com.tenth.Shopping.Entity.Orders;
import com.tenth.Shopping.Error.OrderIdNotFoundException;
import com.tenth.Shopping.Helper.EliminateColumns;
import com.tenth.Shopping.Repository.OrdersRepository;
import lombok.Builder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Builder
@Service
public class OrdersServiceImp implements OrdersService{

    @Autowired
    private OrdersRepository ordersRepository;

    @Override
    public void save(Orders os) {
        ordersRepository.save(os);
    }

    @Override
    public List<EliminateColumns> allOrders(){
        List<Orders>l= ordersRepository.findAll();
        List<EliminateColumns>elc=new ArrayList<>();

        for(int i=0; i<l.size(); i++){
            Orders o=l.get(i);

            EliminateColumns elcObject=EliminateColumns.builder().orderId(o.getOrderId()).amount(o.getAmount()).date(o.getDate()).coupon(o.getCoupon()).build();
            elc.add(elcObject);

        }
        return elc;
    }

    @Override
    public List<Orders> findAllOrdersById(int orderId) throws OrderIdNotFoundException {
        List<Orders> inner= ordersRepository.findByOrderId(orderId);
        if(inner.isEmpty()){
            throw new OrderIdNotFoundException("Order not found");
        }
        return inner;
    }
}
