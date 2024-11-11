package com.example.proyecto_sgp.Observer;

// sujeto Concreto - gestor solicitudes

import java.util.ArrayList;
import java.util.List;

public class GestorSolicitudes implements Sujeto {
    private final List<Observador> observadores;
    private String estadoSolicitud;

    public GestorSolicitudes() {
        observadores = new ArrayList<>();
    }
    
    public String getEstadoSolicitud() {
        return estadoSolicitud;
    }

    
    // cambia el estado de la solicitud y notificar a los observadores
    public void setEstadoSolicitud(String estadoSolicitud) {
        this.estadoSolicitud = estadoSolicitud;
        notificarObservadores("Estado de la solicitud: " + estadoSolicitud);
    }

    public void nuevaSolicitud() {
        notificarObservadores("Nueva solicitud recibida.");
    }

    public void solicitudRetrasada() {
        notificarObservadores("Advertencia: Hay un retraso en la solicitud.");
    }

    @Override
    public void registrarObservador(Observador observador) {
        observadores.add(observador);
    }

    @Override
    public void removerObservador(Observador observador) {
        observadores.remove(observador);
    }

    @Override
    public void notificarObservadores(String mensaje) {
        for (Observador observador : observadores) {
            observador.actualizar(mensaje);
        }
    }
}