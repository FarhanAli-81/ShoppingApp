package com.tenth.Shopping.Helper;


import com.tenth.Shopping.Entity.Stock;
import com.tenth.Shopping.Service.StockService;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;


@Data
public class Order {
   private int orderId;
   private int userId;
   private int quantity;
   private int amount;
   private String coupon;
}
