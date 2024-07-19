package com.example.demo1123456.repo;

import com.example.demo1123456.entity.Gift;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface GiftRepository extends JpaRepository<Gift, Long> {
    List<Gift> findBySenderId(Integer senderId);
}
