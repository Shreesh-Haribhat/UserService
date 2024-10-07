package com.UserService.AuthService.Repository;

import com.UserService.AuthService.Model.Token;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.Optional;

@Repository
public interface TokenRepository extends JpaRepository<Token, Long> {

    Optional<Token> findByValueAndIsDeletedEquals(String token, boolean isDeleted);

    Optional<Token> findByValueAndIsDeletedEqualsAndExpireAtGreaterThan(String token, boolean isDeleted, Date date);
}


