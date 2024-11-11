package com.example.proyecto_sgp.services;

import com.example.proyecto_sgp.entities.Usuario;

import java.util.List;
import java.util.Optional;

public interface UsuarioServicios {
    Usuario crearUsuario(Usuario usuario);
    Usuario modificarUsuario(Usuario usuario, String correo);
    List<Usuario> listarUsuarios();
    Optional<Usuario> buscarUsuarioPorCorreo(String correo);
    void eliminarUsuario(String correo);
}
