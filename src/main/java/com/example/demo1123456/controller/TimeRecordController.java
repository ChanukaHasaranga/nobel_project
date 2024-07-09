package com.example.demo1123456.controller;// TimeRecordController.java

import com.example.demo1123456.entity.TimeRecord;
import com.example.demo1123456.service.TimeRecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/time")
public class TimeRecordController {

    @Autowired
    private TimeRecordService timeRecordService;

    @PutMapping("/update")
    public ResponseEntity<TimeRecord> updateMinutes(@RequestParam Long id, @RequestParam int minutes) {
        try {
            TimeRecord updatedTimeRecord = timeRecordService.updateMinutes(id, minutes);
            return ResponseEntity.ok(updatedTimeRecord);
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/minutes/{id}")
    public ResponseEntity<Integer> getMinutesById(@PathVariable Long id) {
        Optional<TimeRecord> optionalTimeRecord = timeRecordService.getTimeRecord(id);
        if (optionalTimeRecord.isPresent()) {
            return ResponseEntity.ok(optionalTimeRecord.get().getMinutes());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/all")
    public List<TimeRecord> getAllTimeRecords() {
        return timeRecordService.getAllTimeRecords();
    }
}
