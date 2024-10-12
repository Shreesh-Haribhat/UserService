package com.UserService.AuthService.Security.Service;

import com.UserService.AuthService.Model.User;
import com.UserService.AuthService.Repository.UserRepository;
import com.UserService.AuthService.Security.Model.CustomUserDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CustomUserService implements UserDetailsService {

    private UserRepository userRepository;

    @Autowired
    public CustomUserService(UserRepository userRepository)
    {
        this.userRepository = userRepository;
    }
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<User> optionalUser = userRepository.findByEmail(username);
        if(optionalUser.isEmpty())
        {
            throw new UsernameNotFoundException("User with this email does not exist");
        }
        CustomUserDetails customUserDetails = new CustomUserDetails(optionalUser.get());

        return customUserDetails;
    }
}
