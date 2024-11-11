package com.example.proyecto_sgp.auth;

import com.example.proyecto_sgp.strategy.MenuPrincipal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Objects;
import java.util.Scanner;

@Component
public class MenuAuth {
    private MenuPrincipal menuPrincipal;
    private Auth authService;
    private Scanner scanner;

    @Autowired
    public MenuAuth(MenuPrincipal menuPrincipal, Auth authService) {
        this.menuPrincipal = menuPrincipal;
        this.authService = authService;
        this.scanner = new Scanner(System.in);
    }

    public void iniciarSesion() {
        int option;
        do {
            System.out.println("\n=== Login ===");
            System.out.print("Email: ");
            String email = scanner.nextLine();
            System.out.print("Contraseña: ");
            String password = scanner.nextLine();

            // TODO arreglar la comunicación entre apis
            //boolean response = authService.autenticar(email, password);
            boolean response = true;

            if (response) {
                // Verificar el estado del usuario
                /*String estado = authService.getUsuarioEstado(email);
                System.out.println(estado);
                if (!Objects.equals(estado, "ACTIVO")) {
                    System.out.println("Usuario inactivo o pendiente de activación.");
                    return;
                }
                */
                //TODO arreglar la comunicación entre apis
                //String rolUsuario = authService.getUsuarioRol(email);
                String rolUsuario = "admin";
                menuPrincipal.iniciar(rolUsuario);
                return;
            }
            System.out.println("Credenciales incorrectas, ¿Desea volver a intentar?");
            option = scanner.nextInt();
        } while (option != 2);
    }
}
