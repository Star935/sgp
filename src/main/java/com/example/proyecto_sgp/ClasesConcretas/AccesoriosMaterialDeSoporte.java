package com.example.proyecto_sgp.ClasesConcretas;

import com.example.proyecto_sgp.Enums.EstadosElementos;
import com.example.proyecto_sgp.Enums.TipoDeElementos;
import com.example.proyecto_sgp.Producto.ElementosDti;

import java.time.LocalDate;
import java.util.Date;

public class AccesoriosMaterialDeSoporte extends ElementosDti {

    public AccesoriosMaterialDeSoporte(String identificacion, String nombre, String descripcion, String ubicacion, EstadosElementos estado, LocalDate fechaCreacion) {
        super(identificacion, nombre, descripcion, ubicacion, estado, fechaCreacion);
    }

    @Override
    public TipoDeElementos getTipo() {
        return TipoDeElementos.Audiovisual;
    }

    @Override
    public void cambiarEstado(EstadosElementos estado) {
        this.estado = estado;
    }
}
