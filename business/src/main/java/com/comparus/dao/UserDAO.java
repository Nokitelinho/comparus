package com.comparus.dao;

import com.comparus.model.UserModel;

import java.util.List;

public interface UserDAO {

    List<UserModel> findById(Long id);

    List<UserModel> findByUserName(String login);

    List<UserModel> getAllUsers();
}
