package com.tenth.Shopping.Service;


import com.tenth.Shopping.Entity.Stock;
import org.springframework.stereotype.Service;

@Service
public interface StockService {

    public Stock findById(int stockId);
    public void save(Stock stock);
}
