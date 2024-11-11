package com.example.proyecto_sgp.Observer;

// interfaz del sujeto
interface Sujeto {
    void registrarObservador(Observador observador);
    void removerObservador(Observador observador);
    void notificarObservadores(String mensaje);
}