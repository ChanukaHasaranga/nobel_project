package com.example.demo1123456.controller;

import com.example.demo1123456.service.weeklytimeservice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.Map;

@RestController
@RequestMapping("/api/time")
public class timecontroller {
    @Autowired
    private weeklytimeservice weeklyTimeService;

    // Endpoint to get the countdown timer
    @GetMapping("/countdown")
    public String getWeeklyTimeCountdown() {
        return weeklyTimeService.getWeeklyTimeCountdown();
    }

    // Endpoint to update the weekly start time
    @PutMapping("/update")
    public String updateWeeklyTime(@RequestBody Map<String, String> request) {
        LocalDateTime newTime = LocalDateTime.parse(request.get("time"));
        weeklyTimeService.updateWeeklyTime(newTime);
        return "Weekly time updated successfully.";
    }
}