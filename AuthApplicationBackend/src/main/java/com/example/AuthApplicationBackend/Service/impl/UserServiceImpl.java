package com.example.AuthApplicationBackend.Service.impl;

import com.example.AuthApplicationBackend.DTO.UserDto;
import com.example.AuthApplicationBackend.Repository.UserRepository;
import com.example.AuthApplicationBackend.Service.UserService;
import com.example.AuthApplicationBackend.exceptions.ResourcesNotFoundException;
import com.example.AuthApplicationBackend.mapper.UserMapper;
import com.example.AuthApplicationBackend.model.Provider;
import com.example.AuthApplicationBackend.model.Role;
import com.example.AuthApplicationBackend.model.User;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Set;

@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final UserMapper userMapper;


    @Override
@Transactional
    public UserDto createUser(UserDto userDto) {
        if (userDto.getEmail() == null || userDto.getEmail().isBlank()) {
            throw new IllegalArgumentException("Email is required");
        }
        if (userRepository.existsByEmail(userDto.getEmail())) {
            throw new IllegalArgumentException("Email already exists");
        }

        User user = userMapper.toEntity(userDto);
//        user.setPassword(passwordEncoder.encode(userDto.getPassword())); // ✅ encode
        user.setProvider(Provider.LOCAL);                                // ✅ set provider
        user.setRoles(Set.of(Role.USER));                          // ✅ set role
        user.setEnabled(true);                                           // ✅ set enabled

        return userMapper.toDTO(userRepository.save(user));
    }

    @Override
    @Transactional(readOnly = true)
    public boolean updateUser(String email, UserDto userDto) {
        User existingUser=userRepository.findByEmail(email).orElseThrow(()->new RuntimeException("user not found"));
        userMapper.updateEntity(userDto, existingUser);
        userRepository.save(existingUser); // ✅ persist changes
        return true;
    }

    @Override
    @Transactional
    public boolean deleteUser(String email) {
        User user=userRepository.findByEmail(email).orElseThrow(()->new RuntimeException("user not found"));

        userRepository.delete(user);
        return true;
    }

    @Override
    @Transactional(readOnly = true)
    public List<UserDto> getAllUsers() {
        return userMapper.toDTOList(userRepository.findAll());
    }

    @Override
    @Transactional(readOnly = true)
    public UserDto getByEmail(String email) {
        User user = userRepository.findByEmail(email)
                .orElseThrow(() -> new ResourcesNotFoundException("User not found"));
        return userMapper.toDTO(user);
    }
}