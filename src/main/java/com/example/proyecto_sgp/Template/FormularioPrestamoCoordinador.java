package com.example.proyecto_sgp.Template;

// Subclase concreta para el caso de un Coordinador
public class FormularioPrestamoCoordinador extends FormularioPrestamoTemplate {
    @Override
    protected void verificarDisponibilidad() {
        System.out.println("Coordinador: Verificación de disponibilidad exitosa.");
    }

    @Override
    protected void verificarHorario() {
        System.out.println("Coordinador: Verificación de horario exitosa.");
    }

    @Override
    protected void procesarSolicitud() {
        System.out.println("Coordinador: Solicitud procesada exitosamente. El préstamo ha sido aprobado.");
    }
}
