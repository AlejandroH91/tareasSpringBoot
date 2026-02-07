package com.CRUD.servicio;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.CRUD.entidad.Usuarios;
import com.CRUD.repository.UsuarioRepository;

import java.util.List;
import java.util.Optional;

@Service
public class UsuarioServicio {

    @Autowired
    private UsuarioRepository usuarioRepo;

    // Listar todos los usuarios
    public List<Usuarios> listarUsuarios() {
        return usuarioRepo.findAll();
    }

    // Buscar usuario por ID
    public Optional<Usuarios> buscarPorId(Integer id) {
        return usuarioRepo.findById(id);
    }

    // Buscar usuario por username
    public Optional<Usuarios> buscarPorUsername(String username) {
        return usuarioRepo.findByUsername(username);
    }

    // Guardar o actualizar usuario
    public Usuarios guardarUsuario(Usuarios usuario) {
        return usuarioRepo.save(usuario);
    }

    // Eliminar usuario por ID
    public void eliminarUsuario(Integer id) {
        usuarioRepo.deleteById(id);
    }
}
