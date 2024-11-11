package com.example.proyecto_sgp.Mediator;

import java.util.ArrayList;
import java.util.List;

public class Inventario implements Colleague {

    private SistemaMediator mediator;
    private List<Recurso> recursosDisponibles;  // Lista de recursos

    // Constructor
    public Inventario(SistemaMediator mediator) {
        this.mediator = mediator;
        recursosDisponibles = new ArrayList<>();
        
        // Agregar algunos recursos de ejemplo
        recursosDisponibles.add(new Recurso("R001", "Proyector", "videobean", "Sede principa,", "2024-01-01", "2024-01-02", "2024-01-03"));
        recursosDisponibles.add(new Recurso("R002", "Laptop", "portatil", "Sede principal", "2024-02-01", "2024-02-02", "2024-02-03"));
    }

    // Verificar disponibilidad de un recurso
    public void verificarDisponibilidad(Solicitud solicitud) {
        // Buscar el recurso por código o nombre
        Recurso recursoSolicitado = buscarRecurso(solicitud.getElemento());
        
        if (recursoSolicitado != null) {
            System.out.println("El recurso " + recursoSolicitado.getNombre() + " está disponible.");
            recursosDisponibles.remove(recursoSolicitado);  // El recurso ya no está disponible
            mediator.actualizarInventario("Préstamo aprobado para " + recursoSolicitado.getNombre());
        } else {
            System.out.println("El recurso solicitado no está disponible.");
            mediator.actualizarInventario("Préstamo rechazado para el recurso.");
        }
    }

    // Buscar un recurso por su código o nombre
    private Recurso buscarRecurso(String elemento) {
        for (Recurso recurso : recursosDisponibles) {
            if (recurso.getCodigo().equals(elemento) || recurso.getNombre().equals(elemento)) {
                return recurso;
            }
        }
        return null;  // Si no se encuentra el recurso
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
