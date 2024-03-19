package com.comparus.service;

import com.comparus.model.UserModel;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
class UserServiceTest {

    @Autowired
    UserService userService;

    @Test
    void shouldFindAllUsers() {
        var userList = userService.getAllUsers(null, null);

        assertThat(userList).hasSize(6);
    }

    @Test
    void shouldFindUserBySpecification() {
        var userList = userService.findUser(null, "a-login-t1", null, null);

        assertThat(userList.stream().toList())
                .hasSize(1)
                .extracting(UserModel::getUsername)
                .containsExactlyInAnyOrder("a-login-t1");
    }
}