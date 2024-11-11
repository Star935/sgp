package com.example.proyecto_sgp.cue_service;

public class ApiResponse {
    private String mensaje;
    private Object data;
    private String error;

    public ApiResponse(String mensaje, Object data) {
        this.mensaje = mensaje;
        this.data = data;
        this.error = null;
    }

    // Getters y setters
    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }
}