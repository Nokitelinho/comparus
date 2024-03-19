package com.comparus.mapper;

import com.comparus.model.UserModel;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class UserMapper implements RowMapper<UserModel> {

    public UserModel mapRow(ResultSet resultSet, int i) throws SQLException {
        var userModel = new UserModel();

        userModel.setId(resultSet.getLong("user_id"));
        userModel.setUsername(resultSet.getString("login"));
        userModel.setName(resultSet.getString("first_name"));
        userModel.setSurname(resultSet.getString("last_name"));

        return userModel;
    }
}
