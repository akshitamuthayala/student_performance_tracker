package com.fts.studenttracker.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Entity
@Table(name = "admin")
public class Admin {

    // Getters and setters
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(nullable = false, unique = true)
    private String username;

    @Column(nullable = false)
    private String password;

    // Default constructor (required by JPA)
    public Admin() {
    }

    // Constructor with fields
    public Admin(String username, String password) {
        this.username = username;
        this.password = password;
    }

}
