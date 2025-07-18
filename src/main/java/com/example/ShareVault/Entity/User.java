//package com.example.ShareVault.Entity;
//
//import jakarta.persistence.*;
//import lombok.AllArgsConstructor;
//import lombok.*;
////import lombok.Builder;
////import lombok.Data;
////import lombok.NoArgsConstructor;
//
//import java.time.LocalDateTime;
//
//@Entity //marks the class as jpa entity..this will create tables.
//@Data
//@NoArgsConstructor
//@AllArgsConstructor //for getter setter
//@Builder //this will create the objects easily
//@Table(name = "users")
//public class User {
//
//    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private Long id;
//    private String username;
//    private String email;
//    private String password;
//
//    @Enumerated(EnumType.STRING) // instead of switch cases or if-else statements, now enum is used.
//    // Basically where all we have options so we can use this new features of javamaybe java 10
//    private Role role;
//
//    private LocalDateTime createdAt;
//
//}