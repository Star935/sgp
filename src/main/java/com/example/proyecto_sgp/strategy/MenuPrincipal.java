package com.example.proyecto_sgp.strategy;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.InputMismatchException;
import java.util.Scanner;

@Component
public class MenuPrincipal {
    private final MenuFactory menuFactory;
    private final Scanner scanner;

    @Autowired
    public MenuPrincipal(MenuFactory menuFactory) {
        this.menuFactory = menuFactory;
        this.scanner = new Scanner(System.in);
    }

    public void iniciar(String tipoUsuario) {
        try {
            MenuStrategy menu = menuFactory.getMenu(tipoUsuario);
            while (!menu.salir()) {
                menu.mostrarMenu();
                try {
                    int opcion = scanner.nextInt();
                    menu.ejecutarOpcion(opcion);
                } catch (InputMismatchException e) {
                    System.out.println("Por favor, ingrese un número válido");
                    scanner.nextLine(); // Limpiar el buffer
                }
            }
        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}