package com.example.AuthApplicationBackend.mapper;

import com.example.AuthApplicationBackend.DTO.UserDto;
import com.example.AuthApplicationBackend.model.User;
import org.mapstruct.*;

import java.util.List;

@Mapper(componentModel = "spring")
public interface UserMapper {
    // DTO → Entity
//    @Mapping(target = "password" , ignore = true)
    User toEntity(UserDto dto);

    // Entity → DTO
//    @Mapping(target = "password" , ignore = true)

    UserDto toDTO(User entity);

    // List mapping

    List<User> toEntityList(List<UserDto> dtoList);
    List<UserDto> toDTOList(List<User> entityList);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
//    @Mapping(target = "password" , ignore = true)

    void updateEntity(UserDto dto, @MappingTarget User user);
}


