package com.example.proyecto_sgp.cue_service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

@Service
public class ServicioApiExterno {
    private final RestTemplate restTemplate;

    @Autowired
    public ServicioApiExterno(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    // Método para obtener el rol
    public String getRol(String correo) {
        String url = "http://localhost:8080/estudiantes/rol/" + correo;
        ResponseEntity<ApiResponse> response = restTemplate.exchange(
                url,
                HttpMethod.GET,
                null,
                new ParameterizedTypeReference<ApiResponse>() {}
        );

        if (response.getBody() != null && response.getBody().getData() != null) {
            return (String) response.getBody().getData();
        }
        throw new RuntimeException("No se pudo obtener el rol");
    }

    // Método para obtener el estado
    public String getEstado(String correo) {
        String url = "http://localhost:8080/estudiantes/estado/" + correo;
        ResponseEntity<ApiResponse> response = restTemplate.exchange(
                url,
                HttpMethod.GET,
                null,
                new ParameterizedTypeReference<ApiResponse>() {}
        );

        if (response.getBody() != null && response.getBody().getData() != null) {
            return (String) response.getBody().getData();
        }
        throw new RuntimeException("No se pudo obtener el estado");
    }

    // Método para validar usuario
    public Boolean validateUser(String correo, String pass) {
        String url = UriComponentsBuilder.fromHttpUrl("http://localhost:8080/estudiantes/validar")
                .queryParam("correo", correo)
                .queryParam("pass", pass)
                .toUriString();

        ResponseEntity<ApiResponse> response = restTemplate.exchange(
                url,
                HttpMethod.GET,
                null,
                new ParameterizedTypeReference<ApiResponse>() {}
        );

        if (response.getBody() != null && response.getBody().getData() != null) {
            return (Boolean) response.getBody().getData();
        }
        return false;
    }

    // Versión con manejo de errores más detallado
    public Boolean validateUserWithErrorHandling(String correo, String pass) {
        try {
            String url = UriComponentsBuilder.fromHttpUrl("http://localhost:8080/estudiantes/validar")
                    .queryParam("correo", correo)
                    .queryParam("pass", pass)
                    .toUriString();

            ResponseEntity<ApiResponse> response = restTemplate.exchange(
                    url,
                    HttpMethod.GET,
                    null,
                    new ParameterizedTypeReference<ApiResponse>() {}
            );

            if (response.getBody() != null) {
                // Verificar si hay error en la respuesta
                if (response.getBody().getError() != null) {
                    throw new RuntimeException("Error en la validación: " + response.getBody().getError());
                }

                // Verificar si hay datos en la respuesta
                if (response.getBody().getData() != null) {
                    return (Boolean) response.getBody().getData();
                }
            }
            return false;
        } catch (Exception e) {
            System.err.println("Error durante la validación: " + e.getMessage());
            return false;
        }
    }
}