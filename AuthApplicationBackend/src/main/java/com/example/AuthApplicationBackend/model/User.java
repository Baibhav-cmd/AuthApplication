package com.example.AuthApplicationBackend.model;


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
@AllArgsConstructor
@Data
@Builder
@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "user_id")
   private UUID uid;
    @Column(nullable = false , length = 300,name = "user_Name")
    private String name;
   @Column(unique = true, nullable = false , name = "User_Email")
   private String email;
    @Column(nullable = false)
   private  String password;
   private  boolean enabled=true;
   private String gender;
//   private Address address;
   @CreationTimestamp
   private Instant createdAt;
   @UpdateTimestamp
   private Instant updatedAt;
    @Enumerated(EnumType.STRING)
    @ElementCollection(fetch = FetchType.EAGER)
    @CollectionTable(
            name = "user_roles",
            joinColumns = @JoinColumn(name = "user_id"))

    @Builder.Default
    private Set<Role> roles = new HashSet<>();
   @Enumerated(EnumType.STRING)
   @Builder.Default
   private Provider provider=Provider.LOCAL;



}
