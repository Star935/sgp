package com.example.proyecto_sgp.strategy;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class MenuFactory {
    private final MenuEstudiante menuEstudiante;
    private final MenuAdmin menuAdmin;

    @Autowired
    public MenuFactory(MenuEstudiante menuEstudiante, MenuAdmin menuAdmin) {
        this.menuEstudiante = menuEstudiante;
        this.menuAdmin = menuAdmin;
    }

    public MenuStrategy getMenu(String tipo) {
        switch (tipo.toUpperCase()) {
            case "ESTUDIANTE":
                //return menuEstudiante;
                return null;
            case "ADMIN":
                return menuAdmin;
            default:
                throw new IllegalArgumentException("Tipo de menú no válido: " + tipo);
        }
    }
}
