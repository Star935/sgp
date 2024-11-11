package com.example.proyecto_sgp.Memento;

import com.example.proyecto_sgp.Observer.Observador;
import com.example.proyecto_sgp.Observer.NotificacionAdministrador;
import com.example.proyecto_sgp.Observer.NotificacionSolicitante;

public class MainMemento {
    
    public static void main(String[] args) {
        // crea un préstamo y historial
        Prestamo prestamo = new Prestamo();
        HistorialPrestamo historialPrestamo = new HistorialPrestamo();
        
        // crea y registra observers
        Observador notificacionAdmin = new NotificacionAdministrador();
        Observador notificacionSolicitante = new NotificacionSolicitante();
        
        prestamo.registrarObservador(notificacionAdmin);
        prestamo.registrarObservador(notificacionSolicitante);

        // cambia el estado del préstamo y guarda el historial
        prestamo.setEstadoPrestamo("Pendiente");
        historialPrestamo.agregarMemento(prestamo.guardar());

        prestamo.setEstadoPrestamo("Aprobado");
        historialPrestamo.agregarMemento(prestamo.guardar());

        prestamo.setEstadoPrestamo("Entregado");
        historialPrestamo.agregarMemento(prestamo.guardar());

        // restaura un estado anterior en el historial
        prestamo.restaurar(historialPrestamo.obtenerMemento(1));
        System.out.println("Estado restaurado: " + prestamo.getEstadoPrestamo());
    }
}