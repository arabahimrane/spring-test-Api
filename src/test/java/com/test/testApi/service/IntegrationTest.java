package com.test.testApi.service;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;

import com.test.testApi.data.entity.UserEntity;
import com.test.testApi.data.model.User;
import com.test.testApi.rest.UserNotFoundException;

@SpringBootTest
@DirtiesContext(classMode = DirtiesContext.ClassMode.BEFORE_EACH_TEST_METHOD)
public class IntegrationTest {

    @Autowired
    private MyService myService;

    @Test
    public void shuldCreateUser() {
        // Given
        User user = new User(
                "John",
                "john@gmail.com",
                "123456",
                "user");

        // When
        myService.addUser(user);
        UserEntity userCreated = myService.getUserByName("John");
        // Then
        Assertions.assertThat(userCreated.getName()).isEqualTo("John");
        Assertions.assertThat(userCreated.getEmail()).isEqualTo("john@gmail.com");
        Assertions.assertThat(userCreated.getPassword()).isEqualTo("123456");
        Assertions.assertThat(userCreated.getRole()).isEqualTo("user");
    }

    @Test
    public void shuldUpdateUser() {
        // Given
        String userName = "ayman";
        UserEntity newUser = new UserEntity("aymanos", "aymanos@gmail.com", "123456", "ADMIN");
        // When
        myService.updateUser(newUser, userName);
        UserEntity userUpdated = myService.getUserByName(newUser.getName());
        // Then
        Assertions.assertThat(userUpdated.getName()).isEqualTo(newUser.getName());
        Assertions.assertThat(userUpdated.getEmail()).isEqualTo(newUser.getEmail());
        Assertions.assertThat(userUpdated.getPassword()).isEqualTo(newUser.getPassword());
        Assertions.assertThat(userUpdated.getRole()).isEqualTo(newUser.getRole());
    }

    @Test
    public void shuldDeleteUser() {
        // Given
        String userName = "chiwahd";
        // When
        myService.deleteUser(userName);
        // Then
        Assertions.assertThatThrownBy(() -> myService.getUserByName(userName))
                .isInstanceOf(UserNotFoundException.class)
                .hasMessageContaining("Could not find user " + userName);
    }

    @Test
    public void shuldFailWhenUserNotFound() {
        // Given
        String userName = "khalid";
        // When
        // Then
        Assertions.assertThatThrownBy(() -> myService.getUserByName(userName))
                .isInstanceOf(UserNotFoundException.class)
                .hasMessageContaining("Could not find user " + userName);
    }

}
