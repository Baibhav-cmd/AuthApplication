package com.example.AuthApplicationBackend.Controllers;

import com.example.AuthApplicationBackend.DTO.UserDto;
import com.example.AuthApplicationBackend.Service.UserService;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@Data

@RestController
@RequestMapping("api/v1/users")
public class UserController {
    private final UserService userService;


    @PostMapping("/created")
    public ResponseEntity<UserDto> createUser(@RequestBody UserDto userDto){
        return  ResponseEntity.status(HttpStatus.CREATED).body(userService.createUser(userDto));

    }

    @GetMapping("/all")

    public ResponseEntity<List<UserDto>> getAllUser(){
        return  ResponseEntity.status(HttpStatus.FOUND).body(userService.getAllUsers());
    }



}
