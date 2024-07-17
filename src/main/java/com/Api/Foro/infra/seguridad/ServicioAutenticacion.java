package com.Api.Foro.infra.seguridad;


import com.Api.Foro.model.usuario.RepositorioUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class ServicioAutenticacion implements UserDetailsService {
    @Autowired
    private RepositorioUser repositorioUser;
    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        return repositorioUser.findByEmail(email);
    }
}
