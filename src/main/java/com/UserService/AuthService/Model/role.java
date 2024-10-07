package com.UserService.AuthService.Model;

import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class role extends BaseModel{
    private String name;
}
