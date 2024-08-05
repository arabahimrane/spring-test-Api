package com.test.testApi.service;

import java.util.List;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import com.test.testApi.data.UsersEntityList;
import com.test.testApi.data.entity.UserEntity;
import com.test.testApi.data.repository.MyRepository;

public class MyServiceTest {

    @Mock
    private MyRepository myRepository;

    private MyService myService;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
        myService = new MyService(myRepository);

    }
    
    @Test
    public void shuldReturnUsers() {
        // given
        Mockito.when(myRepository.findAll()).thenReturn(UsersEntityList.ALL);
        // when
        List<UserEntity> users = myService.getAllUsers();
        // then
        Assertions.assertThat(users).extracting("name")
                .containsExactly("Marouane", "Rajae", "Souhaila");
    }


    @Test
    public void shouldReturnUserByName() {
        // given
        Mockito.when(myRepository.findOneByNameIgnoreCase("Marouane"))
                .thenReturn(java.util.Optional.of(UsersEntityList.MAROUANE));
        // when
        UserEntity user = myService.getUserByName("Marouane");
        // then
        Assertions.assertThat(user.getName()).isEqualTo("Marouane");
    }
    

}
