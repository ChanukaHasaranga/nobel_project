package com.example.demo1123456.dto;

public class GiftDTO {
    private Long id;
    private String giftId;
    private int senderId;
    private int receiverId;
    private int giftSendCount;

    // Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getGiftId() {
        return giftId;
    }

    public void setGiftId(String giftId) {
        this.giftId = giftId;
    }

    public int getSenderId() {
        return senderId;
    }

    public void setSenderId(int senderId) {
        this.senderId = senderId;
    }

    public int getReceiverId() {
        return receiverId;
    }

    public void setReceiverId(int receiverId) {
        this.receiverId = receiverId;
    }

    public int getGiftSendCount() {
        return giftSendCount;
    }

    public void setGiftSendCount(int giftSendCount) {
        this.giftSendCount = giftSendCount;
    }
}
