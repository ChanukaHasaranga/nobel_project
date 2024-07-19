package com.example.demo1123456.service;// TimeRecordService.java

import com.example.demo1123456.entity.TimeRecord;
import com.example.demo1123456.repo.TimeRecordRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TimeRecordService {

    @Autowired
    private TimeRecordRepository timeRecordRepository;

    public TimeRecord updateMinutes(Long id, int minutes) {
        Optional<TimeRecord> optionalTimeRecord = timeRecordRepository.findById(id);
        if (optionalTimeRecord.isPresent()) {
            TimeRecord timeRecord = optionalTimeRecord.get();
            timeRecord.setMinutes(minutes); // Update minutes instead of adding
            return timeRecordRepository.save(timeRecord);
        } else {
            throw new RuntimeException("TimeRecord not found");
        }
    }

    public Optional<TimeRecord> getTimeRecord(Long id) {
        return timeRecordRepository.findById(id);
    }

    public List<TimeRecord> getAllTimeRecords() {
        return timeRecordRepository.findAll();
    }
}
