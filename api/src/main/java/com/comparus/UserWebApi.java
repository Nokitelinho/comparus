package com.comparus;

import com.comparus.model.UserModel;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@RequestMapping("/api/v1")
public interface UserWebApi {

    List<UserModel> findUser(
            @RequestParam(required = false)  Long id,
            @RequestParam(required = false) String username,
            @RequestParam(required = false) String sort,
            @RequestParam(required = false) String order);
}
