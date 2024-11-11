package com.example.proyecto_sgp.repositories;

import com.example.proyecto_sgp.Producto.ElementosDti;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ElementosDTIRepository extends MongoRepository<ElementosDti, String> {
    Optional<ElementosDti> findByIdentificacion(String identificacion);
    void deleteByIdentificacion(String identificacion);
}
