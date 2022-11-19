package com.example.stock.domain;

import javax.persistence.*;

@Entity
public class Stock {
    // id, productId, quantity

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long productId;

    private Long quantity;

    // Optimistic Lock
    @Version
    private Long version;

    public Stock(){
    }

    public Stock(Long productId, Long quantity){
        this.productId = productId;
        this.quantity = quantity;
    }

    public Long getQuantity() {
        return quantity;
    }

    public void decrease(Long quantity){
        if(this.quantity - quantity < 0){
            throw new RuntimeException("재고가 부족해요");
        }
        this.quantity = this.quantity - quantity;
    }


}
