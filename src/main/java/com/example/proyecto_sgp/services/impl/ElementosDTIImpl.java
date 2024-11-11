package com.example.proyecto_sgp.services.impl;

import com.example.proyecto_sgp.Producto.ElementosDti;
import com.example.proyecto_sgp.repositories.ElementosDTIRepository;
import com.example.proyecto_sgp.services.ElementosDTIService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ElementosDTIImpl implements ElementosDTIService {

    private final ElementosDTIRepository elementosDTIRepository;

    @Autowired
    public ElementosDTIImpl(ElementosDTIRepository elementosDTIRepository) {
        this.elementosDTIRepository = elementosDTIRepository;
    }

    @Override
    public ElementosDti crearElementoDti(ElementosDti elementoDti) {
        return elementosDTIRepository.save(elementoDti);
    }

    @Override
    public ElementosDti actualizarElementoDti(String identificacion, ElementosDti elementoDti) {
        Optional<ElementosDti> elementoExiste = elementosDTIRepository.findByIdentificacion(identificacion);
        if (elementoExiste.isEmpty()) {
            return null;
        }
        elementoDti.setId(elementoExiste.get().getId());
        return elementosDTIRepository.save(elementoDti);
    }

    @Override
    public void eliminarElementoDti(String identificacion) {
        elementosDTIRepository.deleteByIdentificacion(identificacion);
    }

    @Override
    public Optional<ElementosDti> buscarPorIdentificacion(String identificacion) {
        return elementosDTIRepository.findByIdentificacion(identificacion);
    }

    @Override
    public List<ElementosDti> listarTodos() {
        return elementosDTIRepository.findAll();
    }
}
