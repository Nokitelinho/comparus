package dive.dev.common.service;

import dive.dev.common.dto.UserDTO;
import dive.dev.primary.component.PrimaryUserComponent;
import dive.dev.secondary.component.SecondaryUserComponent;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
class UserServiceTest {

    @Autowired
    PrimaryUserComponent primaryUserComponent;

    @Autowired
    SecondaryUserComponent secondaryUserComponent;

    @Autowired
    UserService userService;

    @Test
    void shouldFindAllUsers() {
        var userList = userService.findAll();

        assertThat(userList).hasSize(4);
    }

    @Test
    void shouldFindUserBySpecification() {
        var userList = userService.findUser(null, "a-login-t1", null, null);

        assertThat(userList.stream().toList())
                .hasSize(1)
                .extracting(UserDTO::getUsername)
                .containsExactlyInAnyOrder("a-login-t1");
    }
}