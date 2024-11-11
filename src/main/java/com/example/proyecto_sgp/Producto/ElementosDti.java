package com.example.proyecto_sgp.Producto;

import com.example.proyecto_sgp.Enums.EstadosElementos;
import com.example.proyecto_sgp.Enums.TipoDeElementos;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDate;
import java.util.Date;

@Getter
@Setter
@Document(collection = "elementos_dti")
public abstract class ElementosDti {
    @Id
    private String id;

    //Atributos generales de todos los elementos de Dti
    protected String identificacion;
    protected String nombre;
    protected String descripcion;
    protected String ubicacion;
    protected EstadosElementos estado;
    protected LocalDate fechaCreacion;


    public ElementosDti(String identificacion, String nombre, String descripcion, String ubicacion, EstadosElementos estado, LocalDate fechaCreacion) {
        this.identificacion = identificacion;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.ubicacion = ubicacion;
        this.estado = estado;
        this.fechaCreacion = fechaCreacion;
    }

    //Metodos que todos los elementos deben implementar
    public abstract TipoDeElementos getTipo();
    public abstract void cambiarEstado(EstadosElementos estado);

    public EstadosElementos isEstado() {
        return estado;
    }
}
