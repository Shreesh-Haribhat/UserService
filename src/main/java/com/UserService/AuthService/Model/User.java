package com.UserService.AuthService.Model;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
public class User extends BaseModel{

    public User(){}
    public User(String name, String email, String password) {
        this.name = name;
        this.email = email;
        this.password = password;
        this.roles = new ArrayList<>();
        this.isEmailVerified = false;
    }

    private String name;
    private Boolean isEmailVerified;
    private String email;
    private String password;

    @ManyToMany
    private List<role> roles;



}
