package com.comparus.secondary.models;

import jakarta.persistence.*;
import lombok.Getter;

import java.util.UUID;

@Getter
@Entity
@Table(name = "user_detail")
public class SecondaryUserDetail {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "user_id")
    private UUID id;

    @Column(name = "login")
    private String username;

    @Column(name = "first_name")
    private String name;

    @Column(name = "last_name")
    private String surname;
}
