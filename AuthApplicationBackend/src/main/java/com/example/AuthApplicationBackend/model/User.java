package com.example.AuthApplicationBackend.model;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.Instant;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

@AllArgsConstructor
@Data
@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
   private UUID uuid;
   private String fullName;
   @Column(unique = true)
   private String email;
   private  String password;
   private  boolean enabled=true;
   private String gender;
   private Address address;
   @CreationTimestamp
   private Instant createdAt;
   @UpdateTimestamp
   private Instant updatedAt;
    @Enumerated(EnumType.STRING)
    private Set<Role> roles = new HashSet<>();
   @Enumerated(EnumType.STRING)
   private Provider provider;
}
