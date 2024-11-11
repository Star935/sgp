package com.example.proyecto_sgp.Memento;

import com.example.proyecto_sgp.Observer.GestorSolicitudes;

public class Prestamo extends GestorSolicitudes {
    
    private String estadoPrestamo;

    public void setEstadoPrestamo(String estadoPrestamo) {
        this.estadoPrestamo = estadoPrestamo;
        notificarObservadores("El estado del préstamo ha cambiado a: " + estadoPrestamo);
    }

    public String getEstadoPrestamo() {
        return estadoPrestamo;
    }

    // crea un Memento que guarda el estado actual del préstamo
    public MementoPrestamo guardar() {
        return new MementoPrestamo(estadoPrestamo);
    }

    // restaura el estado del préstamo
    public void restaurar(MementoPrestamo memento) {
        this.estadoPrestamo = memento.getEstadoPrestamo();
        notificarObservadores("El estado del préstamo ha sido restaurado a: " + estadoPrestamo);
    }

    public static class MementoPrestamo {
        private final String estadoPrestamo;

        private MementoPrestamo(String estadoPrestamo) {
            this.estadoPrestamo = estadoPrestamo;
        }

        private String getEstadoPrestamo() {
            return estadoPrestamo;
        }
    }

}
