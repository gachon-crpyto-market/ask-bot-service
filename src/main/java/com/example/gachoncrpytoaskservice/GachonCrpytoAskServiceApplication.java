package com.example.gachoncrpytoaskservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableFeignClients
@SpringBootApplication
public class GachonCrpytoAskServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(GachonCrpytoAskServiceApplication.class, args);
    }

}
