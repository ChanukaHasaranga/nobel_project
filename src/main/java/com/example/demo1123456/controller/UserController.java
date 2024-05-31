package com.example.demo1123456.controller;

import com.example.demo1123456.dto.UserDTO;
import com.example.demo1123456.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping(value = "api/v/user")
@CrossOrigin
public class UserController {
@Autowired
private UserService userService;

    @GetMapping("/getUser")
public List<UserDTO> getUser(){
    return userService.getAllUsers();
}

@PostMapping("/saveUser")
public UserDTO saveuser(
        @RequestParam("id") int id,

        @RequestParam("name") String name,
                        @RequestParam("count") int count,
                        @RequestParam("address") MultipartFile address) throws IOException {
return  userService.saveUser(id,name,count,address);

}
@PutMapping("/updateUser")
public UserDTO updateuser(@RequestParam("id") int id,
                          @RequestParam("name") String name,
                          @RequestParam("count") int count,
                          @RequestParam("address") MultipartFile address) throws  IOException{

        return userService.updateUser(id,name,count,address);
    }

    @DeleteMapping("/deleteUser")
    public String deleteuser(){
        return "User Deleted!";


    }

//    @Autowired
//    private UserService userService;
//
//    @GetMapping("/getUser")
//    public List<UserDTO> getUser(){
//        return userService.getAllUsers();
//    }
//
//    @PostMapping("/saveUser")
//    public UserDTO saveUser(
//            @RequestParam("id") int id,
//            @RequestParam("name") String name,
//            @RequestParam("count") int count,
//            @RequestParam("address") MultipartFile address,
//            @RequestParam("year") int year,
//            @RequestParam("month") int month,
//            @RequestParam("day") int day) throws IOException {
//        return userService.saveUser(id, name, count, address, year, month, day);
//    }
//
//    @PutMapping("/updateUser")
//    public UserDTO updateUser(@RequestParam("id") int id,
//                              @RequestParam("name") String name,
//                              @RequestParam("count") int count,
//                              @RequestParam("address") MultipartFile address,
//                              @RequestParam("year") int year,
//                              @RequestParam("month") int month,
//                              @RequestParam("day") int day) throws IOException {
//        return userService.updateUser(id, name, count, address, year, month, day);
//    }
//
//    @DeleteMapping("/deleteUser")
//    public String deleteUser(){
//        return "User Deleted!";
//    }


}
