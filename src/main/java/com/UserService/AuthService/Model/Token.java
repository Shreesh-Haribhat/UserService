package com.UserService.AuthService.Model;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Entity
@Setter
@Getter
public class Token extends BaseModel{

    @ManyToOne
    private User user;
    private Boolean isDeleted;
    private String value;
    private Date expireAt;
}
