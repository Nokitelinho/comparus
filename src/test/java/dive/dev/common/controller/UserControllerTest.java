package dive.dev.common.controller;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest(webEnvironment= WebEnvironment.RANDOM_PORT)
class UserControllerTest {

    @Autowired
    TestRestTemplate restTemplate;

    @Autowired
    UserController userController;

    @LocalServerPort
    int port;

    @Test
    void contextLoads() {
        assertThat(userController).isNotNull();
    }

    @Test
    void shouldReturnAllUsers() throws Exception {
        String expected = "035670f0-5d53-4691-b72c-4f969a10edc6";
        assertThat(this.restTemplate.getForObject("http://localhost:" + port + "/api/v1/users",
                String.class)).contains(expected);
    }

    @Test
    void shouldFindUserByID() {
        String uuid = "035670f0-5d53-4691-b72c-4f969a10edc6";
        String expected = "Andrew";
        assertThat(this.restTemplate.getForObject("http://localhost:" + port + "/api/v1/search?uuid=" + uuid,
                String.class)).contains(expected);
    }

    @Test
    void shouldFindUserByUsername() {
        String username = "a-login-t1";
        String expected = "Andrew";
        assertThat(this.restTemplate.getForObject("http://localhost:" + port + "/api/v1/search?username=" + username,
                String.class)).contains(expected);
    }

    @Test
    void shouldFindUserByName() {
        String name = "Andrew";
        String expected = "Johnson";
        assertThat(this.restTemplate.getForObject("http://localhost:" + port + "/api/v1/search?name=" + name,
                String.class)).contains(expected);
    }
}