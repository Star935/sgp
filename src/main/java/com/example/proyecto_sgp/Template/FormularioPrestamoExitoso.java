package com.example.proyecto_sgp.Template;

// sublcase concreta para el caso exitoso
public class FormularioPrestamoExitoso extends FormularioPrestamoTemplate {
    @Override
    protected void verificarDisponibilidad() {
        System.out.println("Verificación de disponibilidad exitosa: El recurso está disponible.");
    }

    @Override
    protected void verificarHorario() {
        System.out.println("Verificación de horario exitosa: El horario es permitido.");
    }

    @Override
    protected void procesarSolicitud() {
        System.out.println("Solicitud procesada exitosamente. El préstamo ha sido aprobado.");
    }
}
