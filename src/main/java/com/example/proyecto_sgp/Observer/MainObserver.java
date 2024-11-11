package com.example.proyecto_sgp.Observer;

//probar notificaciones

public class MainObserver {
    public static void main(String[] args) {
        // Crear el sujeto (gestor de solicitudes)
        GestorSolicitudes gestorSolicitudes = new GestorSolicitudes();

        // crea observers
        NotificacionAdministrador notificacionAdministrador = new NotificacionAdministrador();
        NotificacionSolicitante notificacionSolicitante = new NotificacionSolicitante();

        // registra observers
        gestorSolicitudes.registrarObservador(notificacionAdministrador);
        gestorSolicitudes.registrarObservador(notificacionSolicitante);

        // Notificaciones según estado de solicitud
        gestorSolicitudes.nuevaSolicitud();
        gestorSolicitudes.setEstadoSolicitud("Aprobada");
        gestorSolicitudes.solicitudRetrasada();
    }
}