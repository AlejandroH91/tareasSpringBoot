package com.CRUD.servicio;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;

import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.CRUD.entidad.Usuarios;
import com.CRUD.repository.UsuarioRepository;

import java.util.ArrayList;
import java.util.List;

@Service
public class UsuarioDetailsService implements UserDetailsService {//Interfaz de spring

    @Autowired
    private UsuarioRepository usuariosRepositorio;

    @Override
    /*
     * No puedo cambiar el nombre del método ya que es un método que trae la interfaz 
     * UserDetailsService
     *  El método es el equivalente a si username = null lanza la excepción.*/
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Usuarios usuario = usuariosRepositorio.findByUsername(username)
                .orElseThrow(() -> new UsernameNotFoundException("Usuario no encontrado"));
        
        /*
         * GrantedAuthority es un tipo de dato que trae la interfaz de seguridad de Spring
         * y con el reconoce de mi entidad usuario, que si el username cumple con el 
         * boolean es_Admin, le pone "ROLE_ADMIN" para entender que cumple la condición.*/
        List<GrantedAuthority> roles = new ArrayList<>();
        if (usuario.isEsAdmin()) {
            roles.add(new SimpleGrantedAuthority("ROLE_ADMIN")); // Spring necesita "ROLE_" como prefijo
        } else {
            roles.add(new SimpleGrantedAuthority("ROLE_USER"));
        }
        
 

        return new User(usuario.getUsername(),usuario.getPassword(), roles);
    }
}
