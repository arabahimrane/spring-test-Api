package com.test.testApi.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.test.testApi.data.entity.UserEntity;
import com.test.testApi.data.model.User;
import com.test.testApi.data.repository.MyRepository;
import com.test.testApi.rest.UserAllRedyExestException;
import com.test.testApi.rest.UserNotFoundException;

@Service
public class MyService {

    @Autowired
    private MyRepository myRepository;

    public MyService(MyRepository myRepository) {
        this.myRepository = myRepository;
    }

    public UserEntity addUser(User user) {
        Optional<UserEntity> userEntity = myRepository.findOneByNameIgnoreCase(user.name());
        if (userEntity.isPresent()) {
            throw new UserAllRedyExestException(user.name());
        }

        UserEntity newUser = new UserEntity(
                user.name(),
                user.email(),
                user.password(),
                user.role());

        myRepository.save(newUser);
        return getUserByName(user.name());
    }

    public List<UserEntity> getAllUsers() {
        return myRepository.findAll().stream()
                .map(userEntity -> new UserEntity(
                        userEntity.getName(),
                        userEntity.getEmail(),
                        userEntity.getPassword(),
                        userEntity.getRole()))
                .toList();
    }

    public UserEntity getUserByName(String name) {
        UserEntity userEntity = myRepository.findOneByNameIgnoreCase(name)
                .orElseThrow(() -> new UserNotFoundException(name));

        return userEntity;
    }

    public UserEntity updateUser(UserEntity newUser, String userName) {
        UserEntity userEntity = myRepository.findOneByNameIgnoreCase(userName)
                .orElseThrow(() -> new UserNotFoundException(userName));

        userEntity.setName(newUser.getName());
        userEntity.setEmail(newUser.getEmail());
        userEntity.setPassword(newUser.getPassword());
        userEntity.setRole(newUser.getRole());

        myRepository.save(userEntity);
        return userEntity;
    }

    public void deleteUser(String name) {
        UserEntity userEntity = myRepository.findOneByNameIgnoreCase(name)
                .orElseThrow(() -> new UserNotFoundException(name));

        myRepository.delete(userEntity);
    }

}
