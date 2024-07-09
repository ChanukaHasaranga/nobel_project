package com.example.demo1123456.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private int giftSendCount;

    // Getters and Setters

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getGiftSendCount() {
        return giftSendCount;
    }

    public void setGiftSendCount(int giftSendCount) {
        this.giftSendCount = giftSendCount;
    }
}
