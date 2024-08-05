package com.test.testApi.data;

import java.util.List;
import java.util.Arrays;

import com.test.testApi.data.entity.UserEntity;

public class UsersEntityList {

        public static UserEntity MAROUANE = new UserEntity(
                        "Marouane",
                        "marouane@a.com",
                        "123456",
                        "user");

        public static UserEntity RAJAE = new UserEntity(
                        "Rajae",
                        "rajae@a.com",
                        "123456",
                        "user");

        public static UserEntity SOUHAILA = new UserEntity(
                        "Souhaila",
                        "Souhaila@a.com",
                        "123456",
                        "user");

        public static List<UserEntity> ALL = Arrays.asList(MAROUANE, RAJAE, SOUHAILA);
}
