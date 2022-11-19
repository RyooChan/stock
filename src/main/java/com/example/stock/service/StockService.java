package com.example.stock.service;

import com.example.stock.domain.Stock;
import com.example.stock.repository.StockRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@RequiredArgsConstructor
public class StockService {

    private final StockRepository stockRepository;

    @Transactional
    public void decrease(Long id, Long quantity){
        // get stock
        Stock stock = stockRepository.findById(id).orElseThrow();

        // decrease stock
        stock.decrease(quantity);

        // save
        stockRepository.saveAndFlush(stock);
    }
}
