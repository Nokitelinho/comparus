package dive.dev.secondary.component;

import dive.dev.common.dto.UserDTO;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
class SecondaryUserComponentTest {

    @Autowired
    SecondaryUserComponent secondaryUserComponent;

    @Test
    void shouldFindAllUsers() {
        var secondaryUserList = secondaryUserComponent.findAll();

        assertThat(secondaryUserList).hasSize(2);
    }

    @Test
    void shouldFindUserByUserName() {
        var secondaryUserList = secondaryUserComponent.findUser(null, "b-login-t2", null, null);

        assertThat(secondaryUserList.stream().toList())
                .hasSize(1)
                .extracting(UserDTO::getUsername)
                .containsExactlyInAnyOrder("b-login-t2");
    }

    @Test
    void shouldFindUserByName() {
        var secondaryUserList = secondaryUserComponent.findUser(null, null, "Bob", null);

        assertThat(secondaryUserList.stream().toList())
                .hasSize(1)
                .extracting(UserDTO::getName)
                .containsExactlyInAnyOrder("Bob");

    }
}