package com.example.proyecto_sgp.Estado;

import com.example.proyecto_sgp.Producto.ElementosDti;

import java.util.ArrayList;

public class ContextoEstado {

    private Estado estado;

    public void cambiarEstado(Estado estado){
        this.estado=estado;
    }

    public Estado getEstado(){
        return estado;
    }

    public void procesar(ArrayList<ElementosDti> elementosPrestados){
        estado.procesar(this,elementosPrestados);
    }

}
