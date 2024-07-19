package com.example.demo1123456.dto;

public class GiftRequest {

    private int giftSendCount;
    private int receiverId;
    private int senderId;

    // Getters and setters

    public int getGiftSendCount() {
        return giftSendCount;
    }

    public void setGiftSendCount(int giftSendCount) {
        this.giftSendCount = giftSendCount;
    }

    public int getReceiverId() {
        return receiverId;
    }

    public void setReceiverId(int receiverId) {
        this.receiverId = receiverId;
    }

    public int getSenderId() {
        return senderId;
    }

    public void setSenderId(int senderId) {
        this.senderId = senderId;
    }
}
