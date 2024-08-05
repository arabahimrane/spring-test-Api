package com.test.testApi.data.entity;

import jakarta.persistence.*;


@Entity
@Table(name = "users", schema = "public")
public class UserEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "name",length = 50, nullable = false)
    private String name;

    @Column(name = "email",length = 50, nullable = false)
    private String email;

    @Column(name = "password",length = 50, nullable = false)
    private String password;

    @Column(name = "role",length = 50, nullable = false)    
    private String role;

    public UserEntity() {
    }

    public UserEntity(String name, String email, String password, String role) {
        this.name = name;
        this.email = email;
        this.password = password;
        this.role = role;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public String getRole() {
        return role;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setRole(String role) {
        this.role = role;
    }

    
}
