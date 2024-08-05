package com.test.testApi.web;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.test.annotation.DirtiesContext;

import com.test.testApi.data.UsersEntityList;
import com.test.testApi.data.entity.UserEntity;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@DirtiesContext(classMode = DirtiesContext.ClassMode.BEFORE_EACH_TEST_METHOD)
public class EndToEndTest {

    @LocalServerPort
    private int port;

    @Autowired
    private TestRestTemplate restTemplate;

    @SuppressWarnings("null")
    @Test
    public void shuldCreateUser() {
        // Given
        UserEntity newUserEntity = new UserEntity("mohammed", "mohammed@gmail.com", "123456", "user");
        // When
        String url = "http://localhost:" + port + "/api/addUser";
        HttpEntity<UserEntity> request = new HttpEntity<>(newUserEntity);
        ResponseEntity<UserEntity> response = this.restTemplate.exchange(url, HttpMethod.POST, request,
                UserEntity.class);

        // Then
        Assertions.assertThat(response.getBody().getName()).isEqualTo("mohammed");
    }

    @Test
    public void shuldUpdateUser2() {
        // Given
        UserEntity newUserEntity = new UserEntity("Marouane",
                UsersEntityList.MAROUANE.getEmail(),
                UsersEntityList.MAROUANE.getPassword(), "Admin");

        String url = "http://localhost:" + port + "/api/user/" + UsersEntityList.MAROUANE.getName();
        HttpEntity<UserEntity> request = new HttpEntity<>(newUserEntity);
        ResponseEntity<UserEntity> response = this.restTemplate.exchange(url, HttpMethod.PUT, request,
                UserEntity.class);

        // Then
        Assertions.assertThat(response.getStatusCode()).isEqualTo(200);

    }

    @Test
    public void shuldDeleteUser() {
        // Given
        String url = "http://localhost:" + port + "/api/deleteUser/" + "Imrane Arabah";
        HttpEntity<UserEntity> request = new HttpEntity<>(UsersEntityList.MAROUANE);
        ResponseEntity<UserEntity> response = this.restTemplate.exchange(url, HttpMethod.DELETE, request,
                UserEntity.class);

        // Then
        Assertions.assertThat(response.getStatusCode()).isEqualTo(200);
    }

}
