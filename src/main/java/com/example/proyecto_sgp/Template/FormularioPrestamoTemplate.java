package com.example.proyecto_sgp.Template;

// Clase abstracta

public abstract class FormularioPrestamoTemplate {
    // template
    public final void procesarFormulario() {
        verificarDisponibilidad();
        verificarHorario();
        validarDatos();
        procesarSolicitud();
        mostrarResultado();
    }

    // pasos para implementar subclases
    protected abstract void verificarDisponibilidad();
    protected abstract void verificarHorario();
    protected void validarDatos() {
        System.out.println("Validando los datos básicos del préstamo.");
    }
    protected void procesarSolicitud() {
        System.out.println("Procesando la solicitud del préstamo.");
    }
    protected void mostrarResultado() {
        System.out.println("Mostrando el resultado del proceso de solicitud.");
    }
}
