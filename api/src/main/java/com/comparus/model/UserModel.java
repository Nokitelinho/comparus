package com.comparus.model;

import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
public class UserModel {
    private UUID id;
    private String username;
    private String name;
    private String surname;
}
