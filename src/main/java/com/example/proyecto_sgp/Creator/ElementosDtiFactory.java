package com.example.proyecto_sgp.Creator;

import com.example.proyecto_sgp.Enums.EstadosElementos;
import com.example.proyecto_sgp.Producto.ElementosDti;

import java.time.LocalDate;
import java.util.Date;

public abstract class  ElementosDtiFactory {
    public abstract ElementosDti crearElementoDti(String identificacion, String nombre, String descripcion, String ubicacion, EstadosElementos estado, LocalDate fechaCreacion);
}
