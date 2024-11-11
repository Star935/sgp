package com.example.proyecto_sgp.Observer;

public class NotificacionSolicitante implements Observador {
    @Override
    public void actualizar(String mensaje) {
        System.out.println("Notificación para el solicitante: " + mensaje);
    }
}