package com.example.proyecto_sgp;

import com.example.proyecto_sgp.Mediator.SistemaMediator;
import com.example.proyecto_sgp.Mediator.SistemaMediatorImpl;
import com.example.proyecto_sgp.Mediator.Solicitud;
import com.example.proyecto_sgp.Memento.HistorialPrestamo;
import com.example.proyecto_sgp.Memento.Prestamo;
import com.example.proyecto_sgp.Observer.Observador;
import com.example.proyecto_sgp.Observer.GestorSolicitudes;
import com.example.proyecto_sgp.Observer.NotificacionAdministrador;
import com.example.proyecto_sgp.Observer.NotificacionSolicitante;
import com.example.proyecto_sgp.Template.FormularioPrestamoCoordinador;
import com.example.proyecto_sgp.Template.FormularioPrestamoSolicitante;
import com.example.proyecto_sgp.Template.FormularioPrestamoTemplate;

public class MainPatrones {
    public static void main(String[] args) {
        // ejecuta mediator
        ejecutarPatronMediator();

        // ejecuta memento
        ejecutarPatronMemento();

        // ejecuta Observer
        ejecutarPatronObserver();

        // ejecuta template
        ejecutarPatronTemplate();
    }

    private static void ejecutarPatronMediator() {
        
        // crea el mediador
        SistemaMediator sistemaMediator = new SistemaMediatorImpl();
        
        Solicitud solicitud1 = new Solicitud("usuario1", "R001", sistemaMediator);
        Solicitud solicitud2 = new Solicitud("usuario2", "Laptop", sistemaMediator);
        
        solicitud1.enviarSolicitud("R001");
        
        solicitud2.enviarSolicitud("Laptop");
    }

    private static void ejecutarPatronMemento() {
        // crea un préstamo y historial
        Prestamo prestamo = new Prestamo();
        HistorialPrestamo historialPrestamo = new HistorialPrestamo();

        // Crea y registra los observers
        Observador notificacionAdmin = new NotificacionAdministrador();
        Observador notificacionSolicitante = new NotificacionSolicitante();

        prestamo.registrarObservador(notificacionAdmin);
        prestamo.registrarObservador(notificacionSolicitante);

        // Cambia el estado del préstamo y guarda el historial
        prestamo.setEstadoPrestamo("Pendiente");
        historialPrestamo.agregarMemento(prestamo.guardar());

        prestamo.setEstadoPrestamo("Aprobado");
        historialPrestamo.agregarMemento(prestamo.guardar());

        prestamo.setEstadoPrestamo("Entregado");
        historialPrestamo.agregarMemento(prestamo.guardar());

        // restaura un estado anterior en el historial
        prestamo.restaurar(historialPrestamo.obtenerMemento(1)); // Restaurar el "Aprobado"
        System.out.println("Estado restaurado: " + prestamo.getEstadoPrestamo());
    }

    private static void ejecutarPatronObserver() {
        // crea el sujeto (gestor de solicitudes)
        GestorSolicitudes gestorSolicitudes = new GestorSolicitudes();

        // crea observadores
        NotificacionAdministrador notificacionAdministrador = new NotificacionAdministrador();
        NotificacionSolicitante notificacionSolicitante = new NotificacionSolicitante();

        // registra observadores
        gestorSolicitudes.registrarObservador(notificacionAdministrador);
        gestorSolicitudes.registrarObservador(notificacionSolicitante);

        // Notificaciones
        System.out.println("Estado inicial: Nueva solicitud");
        gestorSolicitudes.nuevaSolicitud();

        System.out.println("\nEstado cambiado: Aprobada");
        gestorSolicitudes.setEstadoSolicitud("Aprobada");

        System.out.println("\nEstado cambiado: Retrasada");
        gestorSolicitudes.solicitudRetrasada();
    }

    private static void ejecutarPatronTemplate() {
        // crea formularios con diferentes comportamientos
        FormularioPrestamoTemplate formularioCoordinador = new FormularioPrestamoCoordinador();
        System.out.println("Proceso para Coordinador:");
        formularioCoordinador.procesarFormulario();

        // Simulación de préstamo de recursos para un Solicitante
        FormularioPrestamoTemplate formularioSolicitante = new FormularioPrestamoSolicitante();
        System.out.println("\nProceso para Solicitante:");
        formularioSolicitante.procesarFormulario();
    }

}
