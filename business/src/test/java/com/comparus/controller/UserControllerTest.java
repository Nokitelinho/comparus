package com.comparus.controller;

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
    void shouldReturnAllUsers() {
        String expected = "1";
        assertThat(this.restTemplate.getForObject("http://localhost:" + port + "/api/v1/users",
                String.class)).contains(expected);
    }

    @Test
    void shouldFindUserByID() {
        String id = "1";
        String expected = "Andrew";
        assertThat(this.restTemplate.getForObject("http://localhost:" + port + "/api/v1/search?id=" + id,
                String.class)).contains(expected);
    }

    @Test
    void shouldFindUserByUsername() {
        String username = "a";
        String expected = "Andrew";
        assertThat(this.restTemplate.getForObject("http://localhost:" + port + "/api/v1/search?username=" + username,
                String.class)).contains(expected);
    }
}