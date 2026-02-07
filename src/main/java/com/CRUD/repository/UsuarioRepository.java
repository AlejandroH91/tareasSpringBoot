package com.CRUD.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.CRUD.entidad.Usuarios;
import java.util.Optional;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuarios, Integer> {
    
    Optional<Usuarios> findByUsername(String username);//Devuelve Optional<Usuario> para poder manejar que el usuario no exista sin errores.
}