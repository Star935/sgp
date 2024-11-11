package com.example.proyecto_sgp.Template;

public class MainTemplate {
    public static void main(String[] args) {
        
        FormularioPrestamoTemplate formularioCoordinador = new FormularioPrestamoCoordinador();
        System.out.println("Proceso para Coordinador:");
        formularioCoordinador.procesarFormulario();

        // Simulación de préstamo de recursos para un Solicitante
        FormularioPrestamoTemplate formularioSolicitante = new FormularioPrestamoSolicitante();
        System.out.println("\nProceso para Solicitante:");
        formularioSolicitante.procesarFormulario();
    }
}