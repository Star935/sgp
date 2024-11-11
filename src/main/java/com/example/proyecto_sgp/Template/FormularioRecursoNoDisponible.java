package com.example.proyecto_sgp.Template;

// subclase concreta para recurso no está disponible

public class FormularioRecursoNoDisponible extends FormularioPrestamoTemplate {
    @Override
    protected void verificarDisponibilidad() {
        System.out.println("Verificación fallida: El recurso no está disponible.");
    }

    @Override
    protected void verificarHorario() {
        System.out.println("Verificación de horario exitosa.");
    }

    @Override
    protected void procesarSolicitud() {
        System.out.println("Solicitud no procesada debido a la falta de disponibilidad del recurso.");
    }
}