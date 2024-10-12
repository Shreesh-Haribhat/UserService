package com.UserService.AuthService.Security.Model;

import com.UserService.AuthService.Model.User;
import com.UserService.AuthService.Model.role;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@JsonDeserialize
public class CustomUserDetails implements UserDetails {
    //private User user;

    private List<GrantedAuthority> authorities;
    private String password;
    private String username;
    private boolean accountNonExpired;
    private boolean accountNonLocked;
    private boolean credentialsNonExpired;
    private boolean enabled;

    private Long userId;
    public CustomUserDetails(User user)
    {
        //this.user = user;
        this.accountNonExpired = true;
        this.accountNonLocked = true;
        this.credentialsNonExpired = true;
        this.enabled = true;
        this.password = user.getPassword();
        this.username = user.getEmail();
        this.userId = user.getId();

        List<GrantedAuthority> grantedAuthorityListlist = new ArrayList<>();

        for(role rol : user.getRoles())
        {
            grantedAuthorityListlist.add(new CustomGrantedAuthority(rol));
        }
        this.authorities = grantedAuthorityListlist;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public CustomUserDetails(){}
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
//        List<GrantedAuthority> grantedAuthorityListlist = new ArrayList<>();
//
//        for(role rol : user.getRoles())
//        {
//            grantedAuthorityListlist.add(new CustomGrantedAuthority(rol));
//        }
        return authorities;
    }

    @Override
    public String getPassword() {
//        return user.getPassword();
        return password;
    }

    @Override
    public String getUsername() {
//        return user.getEmail();
        return username;
    }

    @Override
    public boolean isAccountNonExpired() {
        return accountNonExpired;
    }

    @Override
    public boolean isAccountNonLocked() {
        return accountNonLocked;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return credentialsNonExpired;
    }

    @Override
    public boolean isEnabled() {
        return enabled;
    }
}
