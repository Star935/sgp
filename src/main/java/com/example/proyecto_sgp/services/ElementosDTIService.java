package com.example.proyecto_sgp.services;

import com.example.proyecto_sgp.Producto.ElementosDti;

import java.util.List;
import java.util.Optional;

public interface ElementosDTIService {
    ElementosDti crearElementoDti(ElementosDti elementoDti);
    ElementosDti actualizarElementoDti(String identificacion, ElementosDti elementoDti);
    void eliminarElementoDti(String identificacion);
    Optional<ElementosDti> buscarPorIdentificacion(String identificacion);
    List<ElementosDti> listarTodos();
}
