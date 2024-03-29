package com.comparus.repository;

import com.comparus.configuration.Datasource;
import com.comparus.mapper.UserMapper;
import com.comparus.model.UserModel;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Repository
public class UserRepository {

    public List<UserModel> findUser(Datasource datasource, Long id, String username) {
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


        return new JdbcTemplate(getDataSource(datasource))
                .query(sqlQuery.toString(), preparedStatementArgs, new UserMapper());
    }

    private DataSource getDataSource(Datasource datasource) {
        return DataSourceBuilder.create()
                .url(datasource.getUrl())
                .username(datasource.getUsername())
                .password(datasource.getPassword())
                .build();
    }
}
