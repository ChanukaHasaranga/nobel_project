package com.example.demo1123456;

import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling

public class Demo1123456Application {

    public static void main(String[] args) {


        SpringApplication.run(Demo1123456Application.class, args);

    }
    @Bean
    public ModelMapper modelMapper(){
        return new ModelMapper();
    }
//
//    public static void main(String[] args) {
//        SpringApplication.run(Demo1123456Application.class, args);
//    }
//
//    @Bean
//    public ModelMapper modelMapper(){
//        return new ModelMapper();
//    }
}
