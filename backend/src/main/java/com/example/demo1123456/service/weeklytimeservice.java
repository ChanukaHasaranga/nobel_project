package com.example.demo1123456.service;

import com.example.demo1123456.entity.weeklytime;
import com.example.demo1123456.repo.weeklytimerepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.Optional;


@Service
public class weeklytimeservice {
    @Autowired
    private weeklytimerepo weeklyTimeRepository;

    private static final long WEEK_IN_MINUTES = 7 * 24 * 60; // Total minutes in 7 days

    private LocalDateTime getWeeklyTime() {
        Optional<weeklytime> weeklyTime = weeklyTimeRepository.findById(1L);
        return weeklyTime.map(weeklytime::getTime).orElse(null);
    }

    public void updateWeeklyTime(LocalDateTime newTime) {
        weeklytime weeklyTime = new weeklytime(newTime);
        weeklyTime.setId(1L); // Assuming there's a single record with ID 1 for simplicity
        weeklyTimeRepository.save(weeklyTime);
    }

    public String getWeeklyTimeCountdown() {
        LocalDateTime now = LocalDateTime.now();
        LocalDateTime startTime = getWeeklyTime();

        if (startTime == null) {
            startTime = now;
            updateWeeklyTime(startTime);
        }

        // Calculate time until the next 7-day period ends
        long minutesUntilNextWeek = Duration.between(now, startTime.plusWeeks(1)).toMinutes();
        long days = minutesUntilNextWeek / (24 * 60);
        long hours = (minutesUntilNextWeek % (24 * 60)) / 60;
        long minutes = minutesUntilNextWeek % 60;

        return String.format("%d days %d hours %d minutes", days, hours, minutes);
    }

    @Scheduled(fixedRate = 60000) // Check every minute
    public void updateAndCountdown() {
        long remainingMinutes = Duration.between(LocalDateTime.now(), getWeeklyTime().plusWeeks(1)).toMinutes();
        if (remainingMinutes <= 0) {
            // If more than 7 days have passed, update weekly time to current time
            updateWeeklyTime(truncateToNearestMinute(LocalDateTime.now()));
        }
    }

    private LocalDateTime truncateToNearestMinute(LocalDateTime dateTime) {
        return dateTime.withSecond(0).withNano(0);
    }
}
