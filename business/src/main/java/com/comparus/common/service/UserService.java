package com.comparus.common.service;

import com.comparus.model.UserModel;

import java.util.List;
import java.util.UUID;

public interface UserService {
    List<UserModel> findAll();

    List<UserModel> findUser(UUID uuid, String username, String name, String surname);
}
