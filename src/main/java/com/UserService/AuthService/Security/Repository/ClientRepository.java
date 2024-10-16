package com.UserService.AuthService.Security.Repository;

import java.util.Optional;


import com.UserService.AuthService.Security.Model.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClientRepository extends JpaRepository<Client, String> {
    Optional<Client> findByClientId(String clientId);
}