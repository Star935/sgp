package com.example.proyecto_sgp.Mediator;

import java.util.ArrayList;
import java.util.List;

public class SistemaMediatorImpl implements SistemaMediator {
    private List<Solicitud> solicitudes;
    private Inventario inventario;

    public SistemaMediatorImpl() {
        solicitudes = new ArrayList<>();
        inventario = new Inventario(this);
    }

    @Override
    public void procesarSolicitud(Solicitud solicitud) {
        System.out.println("Procesando solicitud de préstamo para: " + solicitud.getElemento());
        inventario.verificarDisponibilidad(solicitud);
    }

    @Override
    public void actualizarInventario(String mensaje) {
        for (Solicitud solicitud : solicitudes) {
            solicitud.recibirActualizacion(mensaje);
        }
    }

    public void agregarSolicitud(Solicitud solicitud) {
        solicitudes.add(solicitud);
    }

    public Inventario getInventario() {
        return inventario;
    }
}
