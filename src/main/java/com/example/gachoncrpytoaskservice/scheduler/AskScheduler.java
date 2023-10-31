package com.example.gachoncrpytoaskservice.scheduler;

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

    @Scheduled(fixedDelay = 1000)
    public void askScheduleTask() {
        System.out.println(askService.getCurrentAskPrice());
    }

}
