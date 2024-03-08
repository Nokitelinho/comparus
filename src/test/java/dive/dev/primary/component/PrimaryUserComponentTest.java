package dive.dev.primary.component;

import dive.dev.common.dto.UserDTO;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
class PrimaryUserComponentTest {
    @Autowired
    PrimaryUserComponent primaryUserComponent;

    @Test
    void shouldFindAllUsers() {
        var primaryUserList = primaryUserComponent.findAll();

        assertThat(primaryUserList).hasSize(2);
    }

    @Test
    void shouldFindUserByUserName() {
        var primaryUserList = primaryUserComponent.findUser(null, "a-login-t1", null, null);

        assertThat(primaryUserList.stream().toList())
                .hasSize(1)
                .extracting(UserDTO::getUsername)
                .containsExactlyInAnyOrder("a-login-t1");
    }

    @Test
    void shouldFindUserByName() {
        var primaryUserList = primaryUserComponent.findUser(null, null, "Andrew", null);

        assertThat(primaryUserList.stream().toList())
                .hasSize(1)
                .extracting(UserDTO::getName)
                .containsExactlyInAnyOrder("Andrew");
    }
}