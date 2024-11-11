package com.example.proyecto_sgp.services.impl;

import com.example.proyecto_sgp.entities.Usuario;
import com.example.proyecto_sgp.repositories.UsuarioRepositorio;
import com.example.proyecto_sgp.services.UsuarioServicios;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UsuarioServiciosImpl implements UsuarioServicios {
    private UsuarioRepositorio usuarioRepositorio;

    @Autowired
    public UsuarioServiciosImpl(UsuarioRepositorio usuarioRepositorio) {
        this.usuarioRepositorio = usuarioRepositorio;
    }

    @Override
    public Usuario crearUsuario(Usuario usuario) {
        return usuarioRepositorio.save(usuario);
    }

    @Override
    public Usuario modificarUsuario(Usuario usuario, String correo) {
        return usuarioRepositorio.save(usuario);
    }

    @Override
    public List<Usuario> listarUsuarios() {
        return usuarioRepositorio.findAll();
    }

    @Override
    public Optional<Usuario> buscarUsuarioPorCorreo(String correo) {
        Optional<Usuario> usuario = usuarioRepositorio.findByCorreo(correo);
        return usuario;
    }

    @Override
    public void eliminarUsuario(String correo) {
        usuarioRepositorio.deletedByCorreo(correo);
    }
}
