package com.example.proyecto_sgp.Prestamos_service.entity;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@Document(collection = "prestamos")
public class Prestamo {

    @Id
    private String id;

    private Usuario usuario;
    private Recurso recurso;
    private String ubicacion;
    private String sede;
    private String estado;
    private LocalDateTime fechaDevolucion;
    private LocalDateTime fechaCreacion;
    private LocalDateTime fechaModificacion;
    private LocalDateTime fechaEliminacion;

    public Prestamo(String id, Usuario usuario, Recurso recurso, String ubicacion, String sede, String estado, 
                    LocalDateTime fechaDevolucion, LocalDateTime fechaCreacion, 
                    LocalDateTime fechaModificacion, LocalDateTime fechaEliminacion) {
        this.id = id;
        this.usuario = usuario;
        this.recurso = recurso;
        this.ubicacion = ubicacion;
        this.sede = sede;
        this.estado = estado;
        this.fechaDevolucion = fechaDevolucion;
        this.fechaCreacion = fechaCreacion;
        this.fechaModificacion = fechaModificacion;
        this.fechaEliminacion = fechaEliminacion;
    }
}
