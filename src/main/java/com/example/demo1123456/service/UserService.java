package com.example.demo1123456.service;

import com.example.demo1123456.dto.UserDTO;
import com.example.demo1123456.entity.User;
import com.example.demo1123456.repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepo userRepository;

    public UserDTO getUserById(int id) {
        Optional<User> user = userRepository.findById(id);
        if (user.isPresent()) {
            return userToDTO(user.get());
        }
        return null; // or throw an exception
    }

    public UserDTO updateGiftSendCount(int id, int giftSendCount) {
        Optional<User> user = userRepository.findById(id);
        if (user.isPresent()) {
            User existingUser = user.get();
            existingUser.setGiftSendCount(existingUser.getGiftSendCount() + giftSendCount);
            userRepository.save(existingUser);
            return userToDTO(existingUser);
        }
        return null; // or throw an exception
    }

    private UserDTO userToDTO(User user) {
        UserDTO userDTO = new UserDTO();
        userDTO.setId(user.getId());
        userDTO.setGiftSendCount(user.getGiftSendCount());
        return userDTO;
    }
}
