package com.comparus.dao.impl;

import com.comparus.dao.UserDAO;
import com.comparus.mapper.UserMapper;
import com.comparus.model.UserModel;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class UserDAOImpl implements UserDAO {
    private JdbcTemplate jdbcTemplate;

    public void setDataSource(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    public List<UserModel> jdbcQuery(Long id, String username) {
        StringBuilder sqlQuery = new StringBuilder("Select * from user_detail where 1=1 ");
        List<String> queryArgs = new ArrayList<>();

        if(Objects.nonNull(id)){
            sqlQuery.append("And user_id = ? ");
            queryArgs.add(id.toString());
        }
        if(Objects.nonNull(username)){
            sqlQuery.append("And login like ? ");
            queryArgs.add("%" + username + "%");
        }

        Object[] preparedStatementArgs = new Object[queryArgs.size()];
        for(int i = 0; i < preparedStatementArgs.length; i++){
            preparedStatementArgs[i] = queryArgs.get(i);
        }


        return jdbcTemplate.query(sqlQuery.toString(), preparedStatementArgs, new UserMapper());
    }
}
