package com.example.proyecto_sgp.Estado;

import com.example.proyecto_sgp.Enums.EstadosPrestamo;
import com.example.proyecto_sgp.Producto.ElementosDti;

import java.util.ArrayList;

public interface Estado {
    void procesar(ContextoEstado contextoEstato, ArrayList<ElementosDti> elementosPrestados);
    EstadosPrestamo getEstadoActual();

}
