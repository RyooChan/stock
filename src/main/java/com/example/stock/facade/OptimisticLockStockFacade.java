package com.example.stock.facade;

import com.example.stock.service.OptimisticLockStockService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class OptimisticLockStockFacade {

    private final OptimisticLockStockService optimisticLockStockService;

    public void decrease(Long id, Long quantity) throws InterruptedException {
        while(true) {
            try{
                optimisticLockStockService.decrease(id, quantity);

                // 정상적으로 업데이트되면 나가기
                break;
            } catch(Exception e){
                // 실패하면 50밀리초 기다렸다가 다시 시도한다.
                Thread.sleep(50);
            }
        }
    }
}
