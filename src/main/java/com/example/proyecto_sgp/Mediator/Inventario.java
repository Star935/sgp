package com.example.proyecto_sgp.Mediator;

import java.util.ArrayList;
import java.util.List;

public class Inventario implements Colleague {
    
    private SistemaMediator mediator;
    private List<String> elementosDisponibles;

    public Inventario(SistemaMediator mediator) {
        this.mediator = mediator;
        elementosDisponibles = new ArrayList<>();
        elementosDisponibles.add("Proyector");
        elementosDisponibles.add("Laptop");
    }

    public void verificarDisponibilidad(Solicitud solicitud) {
        if (elementosDisponibles.contains(solicitud.getElemento())) {
            System.out.println("El elemento " + solicitud.getElemento() + " está disponible.");
            elementosDisponibles.remove(solicitud.getElemento());
            mediator.actualizarInventario("Préstamo aprobado para " + solicitud.getElemento());
        } else {
            System.out.println("El elemento " + solicitud.getElemento() + " no está disponible.");
            mediator.actualizarInventario("Préstamo rechazado para " + solicitud.getElemento());
        }
    }

    @Override
    public void enviarSolicitud(String elemento) {
        System.out.println("Actualizando inventario para el elemento: " + elemento);
    }

    @Override
    public void recibirActualizacion(String mensaje) {
        System.out.println("Inventario recibió actualización: " + mensaje);
    }
}