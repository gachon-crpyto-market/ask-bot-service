package com.example.gachoncrpytoaskservice.service;

import com.example.gachoncrpytoaskservice.dto.request.AskRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Set;

@RequiredArgsConstructor
@Transactional
@Service
public class AskService {
    private final AskFeignClient askFeignClient;
    private final StringRedisTemplate stringRedisTemplate;

    public int getCurrentAskPrice() {
        String currentAsktPriceString = getCurrentAskPriceString();
        return Integer.parseInt(currentAsktPriceString);
    }

    public String sendBotBidPrice(AskRequestDto askRequestDto){
        return askFeignClient.getAskFeignInfo(askRequestDto);
    }

    private String getCurrentAskPriceString() {
        return getKeysByPattern("*").stream()
                .min(String::compareTo)
                .orElse("950");
    }

    private Set<String> getKeysByPattern(String pattern) {
        return stringRedisTemplate.keys(pattern);
    }
}
