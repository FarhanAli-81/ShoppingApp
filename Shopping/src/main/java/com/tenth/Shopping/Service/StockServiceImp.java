package com.tenth.Shopping.Service;

import com.tenth.Shopping.Entity.Stock;
import com.tenth.Shopping.Repository.StockRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StockServiceImp implements StockService{

    @Autowired
    private StockRepository stockRepository;

    @Override
    public Stock findById(int stockId){
        return stockRepository.findById(stockId).get();
    }

    @Override
    public void save(Stock stock){
        stockRepository.save(stock);
    }
}
