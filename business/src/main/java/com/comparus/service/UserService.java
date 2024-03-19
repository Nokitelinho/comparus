package com.comparus.service;

import com.comparus.model.UserModel;

import java.util.List;

public interface UserService {
    List<UserModel> findUsers(Long id, String username, String sort, String order);
}
