package com.UserService.AuthService.DTO;

import com.UserService.AuthService.Model.User;
import com.UserService.AuthService.Model.role;
import jakarta.persistence.ManyToMany;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class UserDto {

    private String name;
    private Boolean isEmailVerified;
    private String email;
    private List<role> roles;

    public static UserDto form(User user)
    {
        UserDto userDto = new UserDto();
        userDto.setEmail(user.getEmail());
        userDto.setName(user.getName());
        userDto.setRoles(user.getRoles());
        userDto.setIsEmailVerified(user.getIsEmailVerified());

        return userDto;
    }

}
