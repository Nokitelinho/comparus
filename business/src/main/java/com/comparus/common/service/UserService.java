package com.comparus.common.service;

import com.comparus.model.UserModel;
import com.comparus.primary.component.PrimaryUserComponent;
import com.comparus.secondary.component.SecondaryUserComponent;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;

import java.util.List;
import java.util.UUID;
import java.util.stream.Stream;

@Service
@RequiredArgsConstructor
public class UserService {
    private final PrimaryUserComponent primaryUserComponent;
    private final SecondaryUserComponent secondaryUserComponent;

    public List<UserModel> findAll() {
        var primaryUserList = primaryUserComponent.findAll();
        var secondaryUserList = secondaryUserComponent.findAll();

        return Stream.concat(primaryUserList.stream(), secondaryUserList.stream()).toList();
    }

    public List<UserModel> findUser(UUID uuid, String username, String name, String surname) {
        var primaryUserList = primaryUserComponent.findUser(uuid, username, name, surname);
        var secondaryUserList = secondaryUserComponent.findUser(uuid, username, name, surname);

        return Stream.concat(primaryUserList.stream(), secondaryUserList.stream()).toList();
    }
}
