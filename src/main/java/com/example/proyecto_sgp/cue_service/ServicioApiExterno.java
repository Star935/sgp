package com.example.proyecto_sgp.cue_service;

import org.springframework.beans.factory.annotation.Autowired;
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

    // Método para hacer una llamada GET
    public String getRol(String correo) {
        String url = "http://localhost:8080/estudiantes/rol/" + correo; // Endpoint del otro servicio
        return restTemplate.getForObject(url, String.class);
    }

    // Método para hacer una llamada GET
    public String getEstado(String correo) {
        String url = "http://localhost:8080/estudiantes/estado/" + correo; // Endpoint del otro servicio
        return restTemplate.getForObject(url, String.class);
    }

    // Método para hacer una llamada GET
    public Boolean validate(String correo, String pass) {
        String url = UriComponentsBuilder.fromHttpUrl("http://localhost:8080/estudiantes/validar")
                .queryParam("correo", correo)
                .queryParam("pass", pass)
                .toUriString();// Endpoint del otro servicio
        return restTemplate.getForObject(url, boolean.class);
    }

}
