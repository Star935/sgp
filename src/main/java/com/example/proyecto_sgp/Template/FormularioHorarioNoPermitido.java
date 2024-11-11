package com.example.proyecto_sgp.Template;

// subclase concreta para horario inhabilitado
public class FormularioHorarioNoPermitido extends FormularioPrestamoTemplate {
    @Override
    protected void verificarDisponibilidad() {
        System.out.println("Verificación de disponibilidad exitosa.");
    }

    @Override
    protected void verificarHorario() {
        System.out.println("Verificación fallida: El horario no es permitido.");
    }

    @Override
    protected void procesarSolicitud() {
        System.out.println("Solicitud no procesada debido a restricciones de horario.");
    }
}