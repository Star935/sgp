package com.example.proyecto_sgp.auth.impl;

import com.example.proyecto_sgp.auth.Auth;
import com.example.proyecto_sgp.cue_service.ServicioApiExterno;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AuthImplService implements Auth {

    private final ServicioApiExterno servicioApiExterno;

    @Autowired
    public AuthImplService(ServicioApiExterno servicioApiExterno) {
        this.servicioApiExterno = servicioApiExterno;
    }

    @Override
    public boolean autenticar(String correo, String pass) {
        try {
            return servicioApiExterno.validateUser(correo, pass);
        } catch (Exception e) {
            System.err.println("Error durante la autenticación: " + e.getMessage());
            return false;
        }
    }

    @Override
    public String getUsuarioRol(String correo) {
        try {
            return servicioApiExterno.getRol(correo);
        } catch (Exception e) {
            System.err.println("Error al obtener el rol: " + e.getMessage());
            return null;
        }    }

    @Override
    public String getUsuarioEstado(String correo) {
        try {
            return servicioApiExterno.getEstado(correo);
        } catch (Exception e) {
            System.err.println("Error al obtener el estado: " + e.getMessage());
            return null;
        }
    }

}
