package com.example.AuthApplicationBackend.Service.impl;

import com.example.AuthApplicationBackend.DTO.UserDto;
import com.example.AuthApplicationBackend.Repository.UserRepository;
import com.example.AuthApplicationBackend.Service.AuthService;
import com.example.AuthApplicationBackend.Service.UserService;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.stereotype.Service;
@Data
@Service
@AllArgsConstructor
public class AuthServiceImpl implements AuthService {
    private final UserService userService;
    @Override
    public UserDto registerUser(UserDto userDto) {
        UserDto  registerUser=userService.createUser(userDto);
        return registerUser;
    }
}
