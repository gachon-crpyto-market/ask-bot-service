package com.example.gachoncrpytoaskservice.service;

import lombok.RequiredArgsConstructor;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Set;

@RequiredArgsConstructor
@Transactional
@Service
public class AskService {
    private final StringRedisTemplate stringRedisTemplate;

    public int getCurrentAskPrice() {
        String currentAsktPriceString = getCurrentAskPriceString();
        return Integer.parseInt(currentAsktPriceString);
    }

    private String getCurrentAskPriceString() {
        return getKeysByPattern("*").stream()
                .min(String::compareTo)
                .get();
    }

    private Set<String> getKeysByPattern(String pattern) {
        return stringRedisTemplate.keys(pattern);
    }
}
