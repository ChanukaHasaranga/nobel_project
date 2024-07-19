package com.example.demo1123456.controller;

import com.example.demo1123456.dto.GiftDTO;
import com.example.demo1123456.dto.GiftSummaryDTO;
import com.example.demo1123456.service.GiftService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v/gift")
@CrossOrigin
public class GiftController {

    @Autowired
    private GiftService giftService;

    @PostMapping("/send")
    public GiftDTO sendGift(
            @RequestParam("senderId") Integer senderId,
            @RequestParam("receiverId") Integer receiverId,
            @RequestParam("giftSendCount") int giftSendCount,
            @RequestParam("giftId") String giftId) {
        return giftService.sendGift(senderId, receiverId, giftSendCount, giftId);
    }

    @GetMapping("/totalGiftCount/{senderId}")
    public String getTotalGiftCount(@PathVariable Integer senderId) {
        int totalGiftCount = giftService.getTotalGiftCount(senderId);
        return "Sender ID: " + senderId + ", Total Gift Count: " + totalGiftCount;
    }

    @GetMapping("/all")
    public List<GiftSummaryDTO> getAllGifts() {
        return giftService.getAllGiftsWithTotalCount();
    }
}
