package com.comparus.controller;

import com.comparus.UserWebApi;
import com.comparus.service.UserService;
import com.comparus.model.UserModel;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
@RequiredArgsConstructor
public class UserController implements UserWebApi {

    private final UserService userService;

    @GetMapping("/users")
    public List<UserModel> findUser(
            @RequestParam(required = false) Long id,
            @RequestParam(required = false) String username,
            @RequestParam(required = false) String sort,
            @RequestParam(required = false) String order) {
        return userService.findUsers(id, username, sort, order);
    }

}
