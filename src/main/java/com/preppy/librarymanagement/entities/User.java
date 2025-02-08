package com.preppy.librarymanagement.entities;

import com.preppy.librarymanagement.entities.enums.Role;
import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "Users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private String name;
    @Column(nullable = false, unique = true)
    private String email;
    @Enumerated(EnumType.STRING)
    private Role role = Role.USER;
    @Column(name = "created_at", updatable = false)
    private final LocalDateTime createdAt = LocalDateTime.now();
    @Column(name = "updated_at")
    private final LocalDateTime updatedAt = LocalDateTime.now();
}

