package com.example.demo1123456.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "gift")
public class Gift {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "gift_id")
    private String giftId;

    @Column(name = "sender_id")
    private Integer senderId;

    @Column(name = "receiver_id")
    private Integer receiverId;

    @Column(name = "gift_send_count")
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

    public Integer getSenderId() {
        return senderId;
    }

    public void setSenderId(Integer senderId) {
        this.senderId = senderId;
    }

    public Integer getReceiverId() {
        return receiverId;
    }

    public void setReceiverId(Integer receiverId) {
        this.receiverId = receiverId;
    }

    public int getGiftSendCount() {
        return giftSendCount;
    }

    public void setGiftSendCount(int giftSendCount) {
        this.giftSendCount = giftSendCount;
    }
}
