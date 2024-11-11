package com.example.proyecto_sgp.auth;

public interface Auth {
    boolean autenticar(String correo, String pass);
    String getUsuarioRol(String correo);
    String getUsuarioEstado(String correo);
}
