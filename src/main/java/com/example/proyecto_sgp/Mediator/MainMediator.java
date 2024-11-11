package com.example.proyecto_sgp.Mediator;

public class MainMediator {

    public static void main(String[] args) {
        
        // crea el mediador
        SistemaMediator sistemaMediator = new SistemaMediatorImpl();
        
        Solicitud solicitud1 = new Solicitud("usuario1", "R001", sistemaMediator);
        Solicitud solicitud2 = new Solicitud("usuario2", "Laptop", sistemaMediator);
        
        solicitud1.enviarSolicitud("R001");
        
        solicitud2.enviarSolicitud("Laptop");
    
    }
}
