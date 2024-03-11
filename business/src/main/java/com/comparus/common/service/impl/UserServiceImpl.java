package com.comparus.common.service.impl;

import com.comparus.common.service.UserService;
import com.comparus.model.UserModel;
import com.comparus.primary.component.PrimaryUserComponent;
import com.comparus.secondary.component.SecondaryUserComponent;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    private final PrimaryUserComponent primaryUserComponent;
    private final SecondaryUserComponent secondaryUserComponent;

    @Override
    public List<UserModel> findAll(String sort, String order) {
        var primaryUserList = primaryUserComponent.findAll();
        var secondaryUserList = secondaryUserComponent.findAll();
        var userModels = Stream.concat(primaryUserList.stream(), secondaryUserList.stream()).toList();

        return userModelList(userModels, sort, order);
    }

    @Override
    public List<UserModel> findUser(UUID uuid, String username, String name, String surname, String sort, String order) {
        var primaryUserList = primaryUserComponent.findUser(uuid, username, name, surname);
        var secondaryUserList = secondaryUserComponent.findUser(uuid, username, name, surname);
        var userModels = Stream.concat(primaryUserList.stream(), secondaryUserList.stream()).toList();

        return userModelList(userModels, sort, order);
    }

    private List<UserModel> userModelList(List<UserModel> userModels, String sort, String order) {
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

}
