package com.example.gachoncrpytoaskservice.scheduler;

import com.example.gachoncrpytoaskservice.dto.request.AskRequestDto;
import com.example.gachoncrpytoaskservice.service.AskService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Slf4j
@RequiredArgsConstructor
@Component
@EnableAsync
@EnableScheduling
public class AskScheduler {
    private final AskService askService;
    private final static int BOT_QUANTITY = 5;
    private final static String BOT_ID = "ask_bot";

    @Scheduled(fixedDelay = 1000)
    public void askScheduleTask() {
        int currentBid = askService.getCurrentAskPrice();
        AskRequestDto askRequestDto = AskRequestDto.of(BOT_ID, currentBid, BOT_QUANTITY);
        String currentBotAsk = askService.sendBotBidPrice(askRequestDto);
        System.out.println(currentBotAsk);
    }

}
