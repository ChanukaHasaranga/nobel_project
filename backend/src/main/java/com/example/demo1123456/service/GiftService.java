package com.example.demo1123456.service;

import com.example.demo1123456.dto.GiftDTO;
import com.example.demo1123456.dto.GiftSummaryDTO;
import com.example.demo1123456.entity.Gift;
import com.example.demo1123456.repo.GiftRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class GiftService {

    @Autowired
    private GiftRepository giftRepository;

    public GiftDTO sendGift(Integer senderId, Integer receiverId, int giftSendCount, String giftId) {
        Gift gift = new Gift();
        gift.setGiftId(giftId);
        gift.setSenderId(senderId);
        gift.setReceiverId(receiverId);
        gift.setGiftSendCount(giftSendCount);
        giftRepository.save(gift);

        return giftToDTO(gift);
    }

    public int getTotalGiftCount(Integer senderId) {
        return giftRepository.findBySenderId(senderId).stream()
                .mapToInt(Gift::getGiftSendCount)
                .sum();
    }

    public List<GiftSummaryDTO> getAllGiftsWithTotalCount() {
        List<Gift> gifts = giftRepository.findAll();
        Map<Integer, Integer> totalGiftCounts = gifts.stream()
                .collect(Collectors.groupingBy(Gift::getSenderId, Collectors.summingInt(Gift::getGiftSendCount)));

        return totalGiftCounts.entrySet().stream()
                .map(entry -> {
                    GiftSummaryDTO dto = new GiftSummaryDTO();
                    dto.setSenderId(entry.getKey());
                    dto.setTotalGiftCount(entry.getValue());
                    return dto;
                })
                .collect(Collectors.toList());
    }

    private GiftDTO giftToDTO(Gift gift) {
        GiftDTO giftDTO = new GiftDTO();
        giftDTO.setId(gift.getId());
        giftDTO.setGiftId(gift.getGiftId());
        giftDTO.setSenderId(gift.getSenderId());
        giftDTO.setReceiverId(gift.getReceiverId());
        giftDTO.setGiftSendCount(gift.getGiftSendCount());
        return giftDTO;
    }
}
