package com.example.proyecto_sgp.Mediator;

public class Recurso {

    private String codigo;
    private String nombre;
    private String tipo;
    private String sede;
    private String fechaIngreso;
    private String fechaDevolucion;
    private String fechaReserva;

    public Recurso(String codigo, String nombre, String tipo, String sede, String fechaIngreso, String fechaDevolucion, String fechaReserva) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.tipo = tipo;
        this.sede = sede;
        this.fechaIngreso = fechaIngreso;
        this.fechaDevolucion = fechaDevolucion;
        this.fechaReserva = fechaReserva;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getSede() {
        return sede;
    }

    public void setSede(String sede) {
        this.sede = sede;
    }

    public String getFechaIngreso() {
        return fechaIngreso;
    }

    public void setFechaIngreso(String fechaIngreso) {
        this.fechaIngreso = fechaIngreso;
    }

    public String getFechaDevolucion() {
        return fechaDevolucion;
    }

    public void setFechaDevolucion(String fechaDevolucion) {
        this.fechaDevolucion = fechaDevolucion;
    }

    public String getFechaReserva() {
        return fechaReserva;
    }

    public void setFechaReserva(String fechaReserva) {
        this.fechaReserva = fechaReserva;
    }
}
