package com.comparus.service;

import com.comparus.model.UserModel;

import java.util.List;

public interface UserService {
    List<UserModel> getAllUsers(String sort, String order);

    List<UserModel> findUser(Long id, String username, String sort, String order);
}
