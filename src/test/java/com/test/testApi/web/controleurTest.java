package com.test.testApi.web;

import com.test.testApi.service.MyService;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import com.test.testApi.data.UsersList;
import com.test.testApi.rest.Controleur;
import com.test.testApi.rest.UserNotFoundException;

import static org.hamcrest.Matchers.hasSize;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.hamcrest.CoreMatchers;

@WebMvcTest(controllers = Controleur.class)
public class controleurTest {

        @Autowired
        private MockMvc mockMvc;

        @MockBean
        private MyService myService;

        @BeforeEach
        public void setUp() {
                MockitoAnnotations.openMocks(this);
        }

        @Test
        public void shouldReturnUsersList() throws Exception {
                // given
                Mockito.when(myService.getAllUsers()).thenReturn(UsersList.ALL);

                // when //then
                mockMvc.perform(get("/api/allUsers"))
                                .andExpect(status().isOk())
                                .andExpect(jsonPath("$", hasSize(3)))
                                .andExpect(jsonPath("$[0].name", CoreMatchers.is("Marouane")))
                                .andExpect(jsonPath("$[1].name", CoreMatchers.is("Rajae")))
                                .andExpect(jsonPath("$[2].name", CoreMatchers.is("Souhaila")));
        }

        @Test
        public void shouldReturnUserByName() throws Exception {
                // given
                String userName = "Marouane";

                Mockito.when(myService.getUserByName(userName)).thenReturn(UsersList.MAROUANE);

                // when //then
                mockMvc.perform(get("/api/user/{userName}", userName))
                                .andExpect(status().isOk())
                                .andExpect(jsonPath("$.name", CoreMatchers.is("Marouane")))
                                .andExpect(jsonPath("$.email", CoreMatchers.is("marouane@a.com")))
                                .andExpect(jsonPath("$.password", CoreMatchers.is("123456")))
                                .andExpect(jsonPath("$.role", CoreMatchers.is("user")));
        }

        @Test
        public void shouldFailToReturnUserByName() throws Exception {
                // given
                String userName = "zoubir";
                Mockito.when(myService.getUserByName(userName))
                                .thenThrow(new UserNotFoundException("Could not find user " + userName));

                // when //then
                mockMvc.perform(get("/api/user/{userName}", userName))
                                .andExpect(status().isNotFound());
        }

}
