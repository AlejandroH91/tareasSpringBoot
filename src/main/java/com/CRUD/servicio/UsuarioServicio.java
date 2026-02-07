package com.CRUD.servicio;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.CRUD.entidad.Usuarios;
import com.CRUD.repository.UsuarioRepository;

import java.util.Collections;

@Service
public class UsuarioServicio implements UserDetailsService {

    @Autowired
    private UsuarioRepository usuarioRepo;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        // Buscar usuario en la BD
        Usuarios usuario = usuarioRepo.findByUsername(username)
                .orElseThrow(() -> new UsernameNotFoundException("Usuario no encontrado: " + username));

        // Crear UserDetails para Spring Security
        return org.springframework.security.core.userdetails.User.builder()
                .username(usuario.getUsername())
                .password(usuario.getPassword())
                .roles(usuario.isEsAdmin() ? "ADMIN" : "USUARIO") // asignamos rol según el boolean
                .build();
    }
}