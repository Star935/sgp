package com.example.proyecto_sgp.Template;

public class MainTemplate {
    public static void main(String[] args) {
        FormularioPrestamoTemplate formulario1 = new FormularioRecursoNoDisponible();
        formulario1.procesarFormulario(); // llama formulario con recurso no disponible

        System.out.println();

        FormularioPrestamoTemplate formulario2 = new FormularioHorarioNoPermitido();
        formulario2.procesarFormulario(); // llama formulario con horario no permitido

        System.out.println();

        FormularioPrestamoTemplate formulario3 = new FormularioPrestamoExitoso();
        formulario3.procesarFormulario(); //llama formulario exitoso
    }
}
