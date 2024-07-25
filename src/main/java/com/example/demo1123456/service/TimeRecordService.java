//package com.example.demo1123456.service;// TimeRecordService.java
//
//import com.example.demo1123456.entity.TimeRecord;
//import com.example.demo1123456.repo.TimeRecordRepository;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//import java.util.List;
//import java.util.Optional;
//
//@Service
//public class TimeRecordService {
//
//    @Autowired
//    private TimeRecordRepository timeRecordRepository;
//
//    public TimeRecord updateMinutes(Long id, int minutes) {
//        Optional<TimeRecord> optionalTimeRecord = timeRecordRepository.findById(id);
//        if (optionalTimeRecord.isPresent()) {
//            TimeRecord timeRecord = optionalTimeRecord.get();
//            timeRecord.setMinutes(minutes); // Update minutes instead of adding
//            return timeRecordRepository.save(timeRecord);
//        } else {
//            throw new RuntimeException("TimeRecord not found");
//        }
//    }
//
//    public Optional<TimeRecord> getTimeRecord(Long id) {
//        return timeRecordRepository.findById(id);
//    }
//
//    public List<TimeRecord> getAllTimeRecords() {
//        return timeRecordRepository.findAll();
//    }
//}
package com.example.demo1123456.service;// TimeRecordService.java

import com.example.demo1123456.entity.TimeRecord;
import com.example.demo1123456.repo.TimeRecordRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.Duration;
import java.time.LocalDateTime;
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

    public TimeRecord login(Long id) {
        Optional<TimeRecord> optionalTimeRecord = timeRecordRepository.findById(id);
        if (optionalTimeRecord.isPresent()) {
            TimeRecord timeRecord = optionalTimeRecord.get();
            timeRecord.setLoginTime(LocalDateTime.now());
            return timeRecordRepository.save(timeRecord);
        } else {
            throw new RuntimeException("TimeRecord not found");
        }
    }

    public TimeRecord logout(Long id) {
        Optional<TimeRecord> optionalTimeRecord = timeRecordRepository.findById(id);
        if (optionalTimeRecord.isPresent()) {
            TimeRecord timeRecord = optionalTimeRecord.get();
            timeRecord.setLogoutTime(LocalDateTime.now());

            if (timeRecord.getLoginTime() != null) {
                Duration duration = Duration.between(timeRecord.getLoginTime(), timeRecord.getLogoutTime());
                int minutesDifference = (int) duration.toMinutes();
                timeRecord.setMinutes(timeRecord.getMinutes() + minutesDifference);
            }

            return timeRecordRepository.save(timeRecord);
        } else {
            throw new RuntimeException("TimeRecord not found");
        }
    }

    public int getMinutes(Long id) {
        Optional<TimeRecord> optionalTimeRecord = timeRecordRepository.findById(id);
        return optionalTimeRecord.map(TimeRecord::getMinutes).orElse(0);
    }
}
