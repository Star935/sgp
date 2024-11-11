package com.example.proyecto_sgp.Mediator;

public class MainMediator {
    public static void main(String[] args) {
        SistemaMediator mediator = new SistemaMediatorImpl();

        Solicitud solicitud1 = new Solicitud("Usuario1", "Proyector", mediator);
        Solicitud solicitud2 = new Solicitud("Usuario2", "Laptop", mediator);
        Solicitud solicitud3 = new Solicitud("Usuario3", "Proyector", mediator);

        solicitud1.enviarSolicitud("Proyector");
        solicitud2.enviarSolicitud("Laptop");
        solicitud3.enviarSolicitud("Proyector");
    }
}
