package com.example.proyecto_sgp.Estado.EstadosConcretos;

import com.example.proyecto_sgp.Enums.EstadosElementos;
import com.example.proyecto_sgp.Enums.EstadosPrestamo;
import com.example.proyecto_sgp.Estado.ContextoEstado;
import com.example.proyecto_sgp.Estado.Estado;
import com.example.proyecto_sgp.Producto.ElementosDti;

import java.util.ArrayList;

public class Activo implements Estado {
    private final EstadosPrestamo estadoActual = EstadosPrestamo.Activo;

    @Override
    public void procesar(ContextoEstado contextoEstato, ArrayList<ElementosDti> elementosPrestados) {
        elementosPrestados.forEach(e -> e.cambiarEstado(EstadosElementos.EN_PRESTAMO));
        System.out.println("Se cambio el estado del prestamo a: "+estadoActual);
    }

    @Override
    public EstadosPrestamo getEstadoActual() {
        return estadoActual;
    }
}
