package com.example.proyecto_sgp.Template;

// Subclase concreta para el caso de un Solicitante
public class FormularioPrestamoSolicitante extends FormularioPrestamoTemplate {
    @Override
    protected void verificarDisponibilidad() {
        System.out.println("Solicitante: Verificación de disponibilidad exitosa.");
    }

    @Override
    protected void verificarHorario() {
        System.out.println("Solicitante: Verificación de horario exitosa.");
    }

    @Override
    protected void procesarSolicitud() {
        System.out.println("Solicitante: Solicitud procesada exitosamente. El préstamo ha sido aprobado.");
    }
}
