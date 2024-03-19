package com.comparus.dao;

import com.comparus.model.UserModel;

import java.util.List;

public interface UserDAO {
    List<UserModel> jdbcQuery(Long id, String login);
}
