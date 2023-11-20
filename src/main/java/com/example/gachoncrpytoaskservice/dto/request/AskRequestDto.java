package com.example.gachoncrpytoaskservice.dto.request;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class AskRequestDto {
    private String userId;
    private int price;
    private int quantity;

    public static AskRequestDto of(String userId, int price, int quantity){
        return AskRequestDto.builder()
                .userId(userId)
                .price(price)
                .quantity(quantity)
                .build();
    }
}
