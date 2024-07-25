//package com.example.demo1123456.controller;// TimeRecordController.java
//
//import com.example.demo1123456.entity.TimeRecord;
//import com.example.demo1123456.service.TimeRecordService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.*;
//
//import java.util.List;
//import java.util.Optional;
//
//@RestController
//@RequestMapping("/time")
//public class TimeRecordController {
//
//    @Autowired
//    private TimeRecordService timeRecordService;
//
//    @PutMapping("/update")
//    public ResponseEntity<TimeRecord> updateMinutes(@RequestParam Long id, @RequestParam int minutes) {
//        try {
//            TimeRecord updatedTimeRecord = timeRecordService.updateMinutes(id, minutes);
//            return ResponseEntity.ok(updatedTimeRecord);
//        } catch (RuntimeException e) {
//            return ResponseEntity.notFound().build();
//        }
//    }
//
//    @GetMapping("/minutes/{id}")
//    public ResponseEntity<Integer> getMinutesById(@PathVariable Long id) {
//        Optional<TimeRecord> optionalTimeRecord = timeRecordService.getTimeRecord(id);
//        if (optionalTimeRecord.isPresent()) {
//            return ResponseEntity.ok(optionalTimeRecord.get().getMinutes());
//        } else {
//            return ResponseEntity.notFound().build();
//        }
//    }
//
//    @GetMapping("/all")
//    public List<TimeRecord> getAllTimeRecords() {
//        return timeRecordService.getAllTimeRecords();
//    }
//}
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

    @PostMapping("/login/{id}")
    public ResponseEntity<TimeRecord> login(@PathVariable Long id) {
        try {
            TimeRecord loggedInRecord = timeRecordService.login(id);
            return ResponseEntity.ok(loggedInRecord);
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping("/logout/{id}")
    public ResponseEntity<TimeRecord> logout(@PathVariable Long id) {
        try {
            TimeRecord loggedOutRecord = timeRecordService.logout(id);
            return ResponseEntity.ok(loggedOutRecord);
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/check/{id}")
    public ResponseEntity<String> checkMinutes(@PathVariable Long id) {
        int minutes = timeRecordService.getMinutes(id);
        if (minutes >= 500) {
            return ResponseEntity.ok("Reached 500 minutes");
        } else {
            return ResponseEntity.ok("Current minutes: " + minutes);
        }
    }
}
