package com.example.AuthApplicationBackend.DTO;

import com.example.AuthApplicationBackend.model.Provider;
import com.example.AuthApplicationBackend.model.Role;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.Instant;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

@NoArgsConstructor

@Data
//@Builder
public class UserDto {

    private UUID uid;
    private String name;
    private String email;
    private  String password;
    private  boolean enabled=true;
    private String gender;
    private Instant createdAt;
    private Instant updatedAt;
    private Set<Role> roles;
    private Provider provider=Provider.LOCAL;

}
