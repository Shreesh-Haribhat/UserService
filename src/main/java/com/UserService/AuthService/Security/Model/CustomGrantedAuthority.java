package com.UserService.AuthService.Security.Model;

import com.UserService.AuthService.Model.role;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import org.springframework.security.core.GrantedAuthority;


@JsonDeserialize
public class CustomGrantedAuthority implements GrantedAuthority {

    public CustomGrantedAuthority(){}
    private String authority;

    //private role role1;
    public CustomGrantedAuthority(role role1)
    {
        //this.role1 = role1;
        this.authority = role1.getName();
    }

    @Override
    public String getAuthority() {
//        return role1.getName();
        return authority;
    }
}
