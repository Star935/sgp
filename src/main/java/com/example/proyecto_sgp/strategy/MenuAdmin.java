package com.example.proyecto_sgp.strategy;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import java.util.Scanner;

@Component
public class MenuAdmin implements MenuStrategy {
    private final Scanner scanner;
    private final GestorElementosDTI gestorElementosDTI;
    private boolean exit = false;

    @Autowired
    public MenuAdmin(GestorElementosDTI gestorElementosDTI) {
        this.scanner = new Scanner(System.in);
        this.gestorElementosDTI = gestorElementosDTI;
    }

    @Override
    public void mostrarMenu() {
        System.out.println("\n=== Menú Administrador ===");
        System.out.println("1. Gestionar Elementos DTI");
        System.out.println("2. Salir");
        System.out.print("Seleccione una opción: ");
    }

    @Override
    public void ejecutarOpcion(int opcion) {
        switch (opcion) {
            case 1:
                gestionarElementosDTI();
                break;
            case 2:
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

    private void gestionarElementosDTI() {
        boolean volverMenuPrincipal = false;
        while (!volverMenuPrincipal) {
            gestorElementosDTI.mostrarMenuDTI();
            try {
                int opcion = scanner.nextInt();
                scanner.nextLine(); // Limpiar buffer
                if (opcion == 6) {
                    volverMenuPrincipal = true;
                } else {
                    gestorElementosDTI.ejecutarOpcionDTI(opcion);
                }
            } catch (Exception e) {
                System.out.println("Error: Ingrese un número válido: " + e);
                scanner.nextLine(); // Limpiar buffer
            }
        }
    }
}