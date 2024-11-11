package com.example.proyecto_sgp.CreadoresConcretos;

import com.example.proyecto_sgp.ClasesConcretas.Audiovisual;
import com.example.proyecto_sgp.Creator.ElementosDtiFactory;
import com.example.proyecto_sgp.Enums.EstadosElementos;
import com.example.proyecto_sgp.Producto.ElementosDti;

import java.time.LocalDate;
import java.util.Date;

public class FabricaDeAudiovisual extends ElementosDtiFactory {

    @Override
    public ElementosDti crearElementoDti(String identificacion, String nombre, String descripcion, String ubicacion, EstadosElementos estado, LocalDate fechaCreacion) {
        return new Audiovisual(identificacion, nombre, descripcion, ubicacion, estado, fechaCreacion);
    }
}