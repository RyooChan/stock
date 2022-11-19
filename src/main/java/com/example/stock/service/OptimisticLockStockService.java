package com.example.stock.service;

import com.example.stock.domain.Stock;
import com.example.stock.repository.StockRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class OptimisticLockStockService {
    private final StockRepository stockRepository;

    @Transactional
    public synchronized void decrease(Long id, Long quantity){
        // get stock
        Stock stock = stockRepository.findByIdWithOptimisticLock(id);

        // decrease stock
        stock.decrease(quantity);

        // save
        stockRepository.saveAndFlush(stock);
    }
}
