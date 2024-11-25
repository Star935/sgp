package com.example.proyecto_sgp.Prestamos_service.service;

import com.example.proyecto_sgp.Prestamos_service.entity.Prestamo;
import com.example.proyecto_sgp.Prestamos_service.repository.PrestamoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PrestamoService {

    @Autowired
    private PrestamoRepository prestamoRepository;

    public List<Prestamo> obtenerTodos() {
        return prestamoRepository.findAll();
    }

    public Prestamo crearPrestamo(Prestamo prestamo) {
        return prestamoRepository.save(prestamo);
    }

    public Prestamo obtenerPorId(String id) {
        return prestamoRepository.findById(id).orElseThrow(() -> new RuntimeException("Préstamo no encontrado"));
    }

    public void eliminarPrestamo(String id) {
        prestamoRepository.deleteById(id);
    }
}