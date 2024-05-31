package com.example.demo1123456.service;

import com.example.demo1123456.dto.UserDTO;
import com.example.demo1123456.entity.User;
import com.example.demo1123456.repo.UserRepo;
import jakarta.transaction.Transactional;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

@Service
@Transactional

//User controller -> Service -> Repo  save wenwaw
public class UserService {

    @Autowired
    private UserRepo userRepo;
    @Autowired
    private ModelMapper modelMapper;

    @Value("${file.upload-dir}")
    private  String UPLOAD_DIR;

    public UserDTO saveUser(int id, String name, int count, MultipartFile Address) throws IOException {
        String Addresspath=saveAddress(Address);
        UserDTO userDTO=new UserDTO(id,name,Addresspath,count);
        userRepo.save(modelMapper.map(userDTO, User.class));
return  userDTO;
    }
    public List<UserDTO> getAllUsers(){
       List<User>userList=userRepo.findAll();
       return modelMapper.map(userList, new TypeToken<List<UserDTO>>(){}.getType());
    }
    public  UserDTO updateUser(int id, String name, int count, MultipartFile Address) throws IOException {
      String Addresspath=saveAddress(Address);
       UserDTO userDTO=new UserDTO(id,name,Addresspath,count);
        userRepo.save(modelMapper.map(userDTO,User.class));
        return userDTO;
    }
    private String saveAddress(MultipartFile Address) throws IOException {
        if (Address.isEmpty()) {
            return null;
        }
        byte[] bytes = Address.getBytes();
        Path path = Paths.get(UPLOAD_DIR + Address.getOriginalFilename());

        if (!Files.exists(path.getParent())){
            Files.createDirectories(path.getParent());
        }


        Files.write(path, bytes);
        return path.toString();
    }
//@Autowired
//private UserRepo userRepo;
//
//    @Autowired
//    private ModelMapper modelMapper;
//
//    @Value("${file.upload-dir}")
//    private String UPLOAD_DIR;
//
//    public UserDTO saveUser(int id, String name, int count, MultipartFile address, int year, int month, int day) throws IOException {
//        String addressPath = saveAddress(address);
//        LocalDate startDate = LocalDate.of(year, month, day);
//        LocalDate newDate = startDate.plusDays(30);
//        String formattedNewDate = newDate.format(DateTimeFormatter.ISO_LOCAL_DATE);
//
//        UserDTO userDTO = new UserDTO(id, name, addressPath, count, year, month, day, formattedNewDate);
//        userRepo.save(modelMapper.map(userDTO, User.class));
//        return userDTO;
//    }
//
//    public List<UserDTO> getAllUsers() {
//        List<User> userList = userRepo.findAll();
//        return userList.stream()
//                .map(this::convertToDTO)
//                .collect(Collectors.toList());
//    }
//
//    public UserDTO updateUser(int id, String name, int count, MultipartFile address, int year, int month, int day) throws IOException {
//        String addressPath = saveAddress(address);
//        LocalDate startDate = LocalDate.of(year, month, day);
//        LocalDate newDate = startDate.plusDays(30);
//        String formattedNewDate = newDate.format(DateTimeFormatter.ISO_LOCAL_DATE);
//
//        UserDTO userDTO = new UserDTO(id, name, addressPath, count, year, month, day, formattedNewDate);
//        userRepo.save(modelMapper.map(userDTO, User.class));
//        return userDTO;
//    }
//
//    private UserDTO convertToDTO(User user) {
//        return modelMapper.map(user, UserDTO.class);
//    }
//
//    private String saveAddress(MultipartFile address) throws IOException {
//        if (address.isEmpty()) {
//            return null;
//        }
//        byte[] bytes = address.getBytes();
//        Path path = Paths.get(UPLOAD_DIR + address.getOriginalFilename());
//
//        if (!Files.exists(path.getParent())) {
//            Files.createDirectories(path.getParent());
//        }
//
//        Files.write(path, bytes);
//        return path.toString();
//    }
}
