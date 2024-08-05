package com.test.testApi.data.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.test.testApi.data.entity.UserEntity;

import java.util.Optional;

@Repository
public interface MyRepository extends JpaRepository<UserEntity, Long> {
    Optional<UserEntity> findOneByNameIgnoreCase(String name);  
}
