package com.example.gachoncrpytoaskservice.service;

import com.example.gachoncrpytoaskservice.dto.request.AskRequestDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;

@FeignClient(name = "ask-feign-client", url = "http://1.237.212.172:3000")
public interface AskFeignClient {
    @PostMapping("/order/ask")
    String getAskFeignInfo(AskRequestDto bidRequestDto);
}