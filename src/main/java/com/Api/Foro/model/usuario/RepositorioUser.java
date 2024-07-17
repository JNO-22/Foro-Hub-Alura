package com.Api.Foro.model.usuario;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.UserDetails;

public interface RepositorioUser extends JpaRepository<User, Long> {

    UserDetails findByEmail(String email);

}
