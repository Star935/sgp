package com.example.proyecto_sgp.strategy;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.crypto.spec.PSource;
import java.util.Scanner;

@Component
public class MenuEstudiante{
    //TODO
    /*private final Scanner scanner;
    private final EstudianteService estudianteService;
    private boolean exit = false;

    @Autowired
    public MenuEstudiante(EstudianteService estudianteService) {
        this.scanner = new Scanner(System.in);
        this.estudianteService = estudianteService;
    }

    @Override
    public void mostrarMenu() {
        System.out.println("\n=== Menú Estudiante ===");
        System.out.println("1. Solicitar prestamo");
        System.out.println("2. Revisar historial de prestamos");
        System.out.println("3. Salir");
        System.out.print("Seleccione una opción: ");
    }

    @Override
    public void ejecutarOpcion(int opcion) {
        switch (opcion) {
            case 1:
                solicitarPrestamos();
                break;
            case 2:
                revisarPrestamos();
                break;
            case 3:
                exit = true;
                System.out.println("¡Hasta pronto!");
                break;
            default:
                System.out.println("Opción no válida");
        }
    }

    @Override
    public boolean salir() {
        return exit;
    }

    private void solicitarPrestamos() {

    }

    private void revisarPrestamos() {
        System.out.println("\n=== Actualizar Información ===");
        // Implementar lógica de actualización
    }

     */
}
