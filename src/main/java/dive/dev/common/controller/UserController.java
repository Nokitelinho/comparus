package dive.dev.common.controller;

import dive.dev.common.dto.UserDTO;
import dive.dev.common.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/v1")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @GetMapping("/users")
    List<UserDTO> findAll() {
        return userService.findAll();
    }

    @GetMapping("/search")
    List<UserDTO> findUser(
            @RequestParam(required = false) UUID uuid,
            @RequestParam(required = false) String username,
            @RequestParam(required = false) String name,
            @RequestParam(required = false) String surname) {
        return userService.findUser(uuid, username, name, surname);
    }
}
