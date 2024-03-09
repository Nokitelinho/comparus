package com.comparus;

import com.comparus.model.UserModel;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.UUID;

@RequestMapping("/api/v1")
public interface UserWebApi {
    @GetMapping("/users")
    List<UserModel> findAll();

    @GetMapping("/search")
    List<UserModel> findUser(
            @RequestParam(required = false) UUID uuid,
            @RequestParam(required = false) String username,
            @RequestParam(required = false) String name,
            @RequestParam(required = false) String surname);
}
