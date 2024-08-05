package com.test.testApi.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.test.testApi.data.entity.UserEntity;
import com.test.testApi.data.model.User;
import com.test.testApi.service.MyService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;

@Tag(name = "MyService", description = "MyService  first API")
@RestController
@RequestMapping("/api")
public class Controleur {

    @Autowired
    private MyService myService;

    @Operation(summary = "Creates a user", description = "Creates a user")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Created user", content = {
                    @Content(mediaType = "application/json", schema = @Schema(implementation = User.class)) }),

            @ApiResponse(responseCode = "409", description = "User already exists", content = {
                    @Content(mediaType = "application/json") }) })

    @PostMapping("/addUser")
    public UserEntity addUser(@Valid @RequestBody User user) {
        return myService.addUser(user);
    }

    @Operation(summary = "get All user", description = "get All user inside table")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "List User", content = @Content(mediaType = "application/json", array = @ArraySchema(schema = @Schema(implementation = User.class)))),
            @ApiResponse(responseCode = "500", description = "Internal server error", content = @Content(mediaType = "application/json", schema = @Schema(implementation = User.class))) })

    @GetMapping("/allUsers")
    public List<UserEntity> getAllUsers() {
        return myService.getAllUsers();
    }

    @Operation(summary = "get User by name", description = "search user by name")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "User found", content = @Content(mediaType = "application/json", schema = @Schema(implementation = User.class))),
            @ApiResponse(responseCode = "404", description = "User not found", content = @Content(mediaType = "application/json", schema = @Schema(implementation = User.class))) })

    @GetMapping("/user/{name}")
    public UserEntity getUser(@PathVariable("name") String name) {
        return myService.getUserByName(name);
    }

    @Operation(summary="Update a user",description="Update a user")
    @ApiResponses(value={
        @ApiResponse(responseCode="200",description="Update user",content={@Content(mediaType="application/json",schema=@Schema(implementation=User.class))}),
        @ApiResponse(responseCode="404",description="User not found",content={@Content(mediaType="application/json",schema=@Schema(implementation=User.class))})
    })
    @PutMapping("/user/{userName}")
    public UserEntity updateUser(@Valid @RequestBody UserEntity user, @PathVariable String userName) {
        return myService.updateUser(user, userName);
    }

    @Operation(summary = "Update a user", description = "Update a user")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Update user", content = {
                    @Content(mediaType = "application/json", schema = @Schema(implementation = User.class)) }),

    })

    @DeleteMapping("/deleteUser/{name}")
    public void delEntity(@PathVariable("name") String name) {
        myService.deleteUser(name);
    }

}
