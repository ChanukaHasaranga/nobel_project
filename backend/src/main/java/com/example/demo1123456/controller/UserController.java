package com.example.demo1123456.controller;

import com.example.demo1123456.dto.UserDTO;
import com.example.demo1123456.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "api/v/user")
@CrossOrigin
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/{id}")
    public UserDTO getUserById(@PathVariable int id) {
        return userService.getUserById(id);
    }

    @PutMapping("/{id}/updateGiftSendCount")
    public UserDTO updateGiftSendCount(
            @PathVariable int id,
            @RequestParam("giftSendCount") int giftSendCount) {
        return userService.updateGiftSendCount(id, giftSendCount);
    }
}
