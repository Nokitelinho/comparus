package com.comparus.service.impl;

import com.comparus.configuration.ConfigProperties;
import com.comparus.configuration.Datasource;
import com.comparus.dao.UserDAO;
import com.comparus.dao.impl.UserDAOImpl;
import com.comparus.service.UserService;
import com.comparus.model.UserModel;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    private final ConfigProperties configProperties;

    @Override
    public List<UserModel> getAllUsers(String sort, String order) {
        var datasourceList = configProperties.getDatasource();

        List<UserModel> userModels = datasourceList.stream()
                .map(this::getUserDAO)
                .map(UserDAO::getAllUsers)
                .flatMap(Collection::stream)
                .collect(Collectors.toList());

        return sortUserModels(userModels, sort, order);
    }

    @Override
    public List<UserModel> findUser(Long id, String username, String sort, String order) {
        if (Objects.nonNull(id)) return findById(id, sort, order);
        if (Objects.nonNull(username)) return findByUserName(username, sort, order);

        return new ArrayList<>();
    }

    private List<UserModel> findById(Long id, String sort, String order) {
        var datasourceList = configProperties.getDatasource();

        List<UserModel> userModels = datasourceList.stream()
                .map(this::getUserDAO)
                .map(u->u.findById(id))
                .flatMap(Collection::stream)
                .collect(Collectors.toList());

        return sortUserModels(userModels, sort, order);
    }

    private List<UserModel> findByUserName(String username, String sort, String order) {
        var datasourceList = configProperties.getDatasource();

        List<UserModel> userModels = datasourceList.stream()
                .map(this::getUserDAO)
                .map(u->u.findByUserName(username))
                .flatMap(Collection::stream)
                .collect(Collectors.toList());

        return sortUserModels(userModels, sort, order);
    }

    private List<UserModel> sortUserModels(List<UserModel> userModels, String sort, String order) {
        var sortOrder = Objects.nonNull(order) && order.equals("asc") ? "asc" : "desc";

        if (Objects.nonNull(sort)) {
            switch (sort) {
                case "username":
                    var compareByUsername = sortOrder.equals("asc") ? Comparator
                            .comparing(UserModel::getUsername) : Comparator
                            .comparing(UserModel::getUsername).reversed();
                    return userComparator(userModels, compareByUsername);
                case "name":
                    var compareByName = sortOrder.equals("asc") ? Comparator
                            .comparing(UserModel::getName) : Comparator
                            .comparing(UserModel::getName).reversed();
                    return userComparator(userModels, compareByName);
                case "surname":
                    var compareBySurname = sortOrder.equals("asc") ? Comparator
                            .comparing(UserModel::getSurname) : Comparator
                            .comparing(UserModel::getName).reversed();
                    return userComparator(userModels, compareBySurname);
            }
        }

        return userModels;
    }

    private List<UserModel> userComparator(List<UserModel> userModels, Comparator<UserModel> compareBy) {
        return userModels.stream()
                .sorted(compareBy)
                .collect(Collectors.toCollection(ArrayList::new));
    }

    private UserDAO getUserDAO(Datasource datasource) {

        var ds = DataSourceBuilder.create()
                .url(datasource.getUrl())
                .username(datasource.getUsername())
                .password(datasource.getPassword())
                .build();

        var userDAO = new UserDAOImpl();
        userDAO.setDataSource(ds);

        return userDAO;
    }

}