package com.comparus.dao.impl;

import com.comparus.dao.UserDAO;
import com.comparus.mapper.UserMapper;
import com.comparus.model.UserModel;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;
import java.util.List;

public class UserDAOImpl implements UserDAO {
    private JdbcTemplate jdbcTemplate;

    private final String SQL_FIND_BY_ID = "select * from user_detail where user_id = ?";
    private final String SQL_FIND_BY_USERNAME = "select * from user_detail where login like ?";
    private final String SQL_GET_ALL = "select * from user_detail";

    public void setDataSource(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    public List<UserModel> findById(Long id) {
        return jdbcTemplate.query(SQL_FIND_BY_ID, new Object[]{id}, new UserMapper());
    }

    public List<UserModel> findByUserName(String login) {
        return jdbcTemplate.query(SQL_FIND_BY_USERNAME, new Object[]{"%" + login + "%"}, new UserMapper());
    }

    public List<UserModel> getAllUsers() {
        return jdbcTemplate.query(SQL_GET_ALL, new UserMapper());
    }
}
