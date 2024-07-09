package com.example.demo1123456.repo;// TimeRecordRepository.java

import com.example.demo1123456.entity.TimeRecord;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TimeRecordRepository extends JpaRepository<TimeRecord, Long> {
}
