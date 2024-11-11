package com.example.proyecto_sgp.Mediator;

public class Solicitud implements Colleague {
    private String usuario;
    private String elemento;
    private SistemaMediator mediator;

    public Solicitud(String usuario, String elemento, SistemaMediator mediator) {
        this.usuario = usuario;
        this.elemento = elemento;
        this.mediator = mediator;
        mediator.procesarSolicitud(this);
    }

    public String getElemento() {
        return elemento;
    }

    @Override
    public void enviarSolicitud(String elemento) {
        System.out.println(usuario + " solicitó el préstamo del elemento: " + elemento);
        mediator.procesarSolicitud(this);
    }

    @Override
    public void recibirActualizacion(String mensaje) {
        System.out.println(usuario + " recibió actualización: " + mensaje);
    }
}