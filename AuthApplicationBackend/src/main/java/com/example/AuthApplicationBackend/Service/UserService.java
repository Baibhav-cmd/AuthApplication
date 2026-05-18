package com.example.AuthApplicationBackend.Service;

import com.example.AuthApplicationBackend.DTO.UserDto;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;



public interface UserService {
    UserDto createUser(UserDto userDto);
    boolean updateUser(UUID userId,UserDto userDto);
    boolean deleteUser(UUID userId);
    List<UserDto> getAllUsers();
    UserDto getByUserId(UUID userid);

}
