package com.example.proyecto_sgp.Memento;

// Clase Caretaker

import java.util.ArrayList;
import java.util.List;

public class HistorialPrestamo {
    
    private final List<Prestamo.MementoPrestamo> listaMementos = new ArrayList<>();

    public void agregarMemento(Prestamo.MementoPrestamo memento) {
        listaMementos.add(memento);
    }

    public Prestamo.MementoPrestamo obtenerMemento(int indice) {
        return listaMementos.get(indice);
    }
}