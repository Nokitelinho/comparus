package com.comparus;

import com.comparus.model.UserModel;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@RequestMapping("/api/v1")
public interface UserWebApi {
    List<UserModel> findAll(
            @RequestParam(required = false) String sort,
            @RequestParam(required = false) String order);

    List<UserModel> findUser(
            Long id,
            @RequestParam(required = false) String username,
            @RequestParam(required = false) String sort,
            @RequestParam(required = false) String order);
}
