package com.example.demo1123456.repo;

import com.example.demo1123456.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepo extends JpaRepository<User, Integer> {
}
