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
import com.example.proyecto_sgp.Template.FormularioHorarioNoPermitido;
import com.example.proyecto_sgp.Template.FormularioPrestamoExitoso;
import com.example.proyecto_sgp.Template.FormularioPrestamoTemplate;
import com.example.proyecto_sgp.Template.FormularioRecursoNoDisponible;

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
        // crea el Mediator
        SistemaMediator mediator = new SistemaMediatorImpl();

        // Crea las solicitudes
        Solicitud solicitud1 = new Solicitud("Usuario1", "Proyector", mediator);
        Solicitud solicitud2 = new Solicitud("Usuario2", "Laptop", mediator);
        Solicitud solicitud3 = new Solicitud("Usuario3", "Proyector", mediator);

        // Envia solicitudes al mediador
        solicitud1.enviarSolicitud("Proyector");
        solicitud2.enviarSolicitud("Laptop");
        solicitud3.enviarSolicitud("Proyector");
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
        FormularioPrestamoTemplate formulario1 = new FormularioRecursoNoDisponible();
        formulario1.procesarFormulario(); // ejecuta el formulario con recurso no disponible

        System.out.println(); // espacio para separar los resultados

        FormularioPrestamoTemplate formulario2 = new FormularioHorarioNoPermitido();
        formulario2.procesarFormulario(); // ejecuta el formulario con horario no permitido

        System.out.println(); // espacio para separar los resultados

        FormularioPrestamoTemplate formulario3 = new FormularioPrestamoExitoso();
        formulario3.procesarFormulario(); // llama formulario exitoso
    }

}
