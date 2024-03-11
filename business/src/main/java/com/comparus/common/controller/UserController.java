package com.comparus.common.controller;

import com.comparus.UserWebApi;
import com.comparus.common.service.UserService;
import com.comparus.model.UserModel;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.UUID;


@RestController
@RequiredArgsConstructor
public class UserController implements UserWebApi {

    private final UserService userService;

    @GetMapping("/users")
    public List<UserModel> findAll(@RequestParam(required = false) String sort, @RequestParam(required = false) String order) {
        return userService.findAll(sort, order);
    }

    @GetMapping("/search")
    public List<UserModel> findUser(
            @RequestParam(required = false) UUID uuid,
            @RequestParam(required = false) String username,
            @RequestParam(required = false) String name,
            @RequestParam(required = false) String surname,
            @RequestParam(required = false) String sort,
            @RequestParam(required = false) String order) {
        return userService.findUser(uuid, username, name, surname, sort, order);
    }

}
