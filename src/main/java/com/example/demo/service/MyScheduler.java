package com.example.demo.service;


import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class MyScheduler {

   // @Scheduled(fixedRate = 5000)
    public void dynamicScheduledTask() {
        System.out.println("Task executed at: " + System.currentTimeMillis());
    }
}