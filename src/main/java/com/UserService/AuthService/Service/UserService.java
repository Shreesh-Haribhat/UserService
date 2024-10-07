package com.UserService.AuthService.Service;

import com.UserService.AuthService.Model.Token;
import com.UserService.AuthService.Model.User;
import com.UserService.AuthService.Repository.UserRepository;
import com.UserService.AuthService.Repository.TokenRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Calendar;
import java.util.Date;
import java.util.Optional;
import java.util.UUID;

@Service
public class UserService {

    private UserRepository userRepository;
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    private TokenRepository tokenRepository;

    @Autowired
    public UserService(UserRepository userRepository,BCryptPasswordEncoder bCryptPasswordEncoder,
                       TokenRepository tokenRepository)
    {
        this.userRepository = userRepository;
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
        this.tokenRepository = tokenRepository;
    }
    public User signUp(String email,String password,String name)
    {
        User user = new User();
        user.setEmail(email);
        user.setName(name);
        user.setPassword(bCryptPasswordEncoder.encode(password));

        return userRepository.save(user);

    }

    public Token login(String email, String password)
    {
        Optional<User> optionalUser = userRepository.findByEmail(email);
        if(optionalUser.isEmpty())
        {
            throw new RuntimeException("Invalid Email or Password");
        }

        User user = optionalUser.get();

        if (!bCryptPasswordEncoder.matches(password,  user.getPassword())) {
            throw new RuntimeException("Invalid Email or Password");
        }

        Token token = new Token();
        token.setUser(user);
        token.setValue(UUID.randomUUID().toString());
        token.setIsDeleted(false);

        Date date = getExpireDate();
        token.setExpireAt(date);

        return tokenRepository.save(token);
    }

    //Getting the expiring Date from the current date
    public Date getExpireDate()
    {
        Calendar instance = Calendar.getInstance();
        instance.setTime(new Date());

        instance.add(Calendar.DAY_OF_MONTH,30);

        Date expireDate = instance.getTime();

        return expireDate;
    }

    public void logout(String token)
    {
        Optional<Token> optionalUser = tokenRepository.findByValueAndIsDeletedEquals(token,false);
        if(optionalUser.isEmpty())
        {
            throw new RuntimeException("User is invalid");
        }

        Token savedToken = optionalUser.get();

        savedToken.setIsDeleted(true);

        tokenRepository.save(savedToken);

    }

    public Boolean validate(String token)
    {
        Optional<Token> optionalToken = tokenRepository.findByValueAndIsDeletedEqualsAndExpireAtGreaterThan(token,false,new Date());

        if(optionalToken.isEmpty())
        {
            return false;
        }
        return true;
    }

}
