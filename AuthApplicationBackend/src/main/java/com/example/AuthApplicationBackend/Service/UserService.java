package com.example.AuthApplicationBackend.Service;

import com.example.AuthApplicationBackend.DTO.UserDto;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;



public interface UserService {
    UserDto createUser(UserDto userDto);
    boolean updateUser(String email,UserDto userDto);
    boolean deleteUser(String email);
    List<UserDto> getAllUsers();
    UserDto getByEmail(String email);

}
