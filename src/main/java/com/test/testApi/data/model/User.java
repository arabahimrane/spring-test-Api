package com.test.testApi.data.model;

import jakarta.validation.constraints.NotNull;

public record User(
        @NotNull(message = "name do not be fals") String name,
        @NotNull(message = "email do not be fals") String email,
        @NotNull(message = "password do not be fals") String password,
        @NotNull(message = "rale do not be fals") String role) {

}
