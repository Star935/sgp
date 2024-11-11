package com.example.proyecto_sgp.entities;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

@Document(collection = "usuarios")
@Getter
@Setter
public class Usuario {
    @Id
    private String id;
    private String correo;
    private String rol;
    private String estado;
    private Date fechaCreacion;
    private Date fechaModicacion;
    private Date fechaEliminacion;
}
