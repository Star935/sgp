package com.example.proyecto_sgp.strategy;


import com.example.proyecto_sgp.CreadoresConcretos.FabricaDeAccesorios;
import com.example.proyecto_sgp.CreadoresConcretos.FabricaDeAudiovisual;
import com.example.proyecto_sgp.CreadoresConcretos.FabricaDeComputadores;
import com.example.proyecto_sgp.CreadoresConcretos.FabricaDeControles;
import com.example.proyecto_sgp.Creator.ElementosDtiFactory;
import com.example.proyecto_sgp.Enums.EstadosElementos;
import com.example.proyecto_sgp.Producto.ElementosDti;
import com.example.proyecto_sgp.services.ElementosDTIService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;

@Component
public class GestorElementosDTI {
    private final ElementosDTIService elementosDTIService;
    private final Scanner scanner;
    private final ElementosDtiFactory[] fabricas = {
            new FabricaDeComputadores(),
            new FabricaDeControles(),
            new FabricaDeAudiovisual(),
            new FabricaDeAccesorios()
    };

    @Autowired
    public GestorElementosDTI(ElementosDTIService elementosDTIService) {
        this.elementosDTIService = elementosDTIService;
        this.scanner = new Scanner(System.in);
    }

    public void mostrarMenuDTI() {
        System.out.println("\n=== Gestión de Elementos DTI ===");
        System.out.println("1. Crear nuevo elemento");
        System.out.println("2. Buscar elemento");
        System.out.println("3. Actualizar elemento");
        System.out.println("4. Eliminar elemento");
        System.out.println("5. Listar todos los elementos");
        System.out.println("6. Volver al menú principal");
    }

    public void ejecutarOpcionDTI(int opcion) {
        switch (opcion) {
            case 1:
                crearElemento();
                break;
            case 2:
                buscarElemento();
                break;
            case 3:
                actualizarElemento();
                break;
            case 4:
                eliminarElemento();
                break;
            case 5:
                listarElementos();
                break;
            case 6:
                return;
            default:
                System.out.println("Opción no válida");
        }
    }

    private void crearElemento() {
        System.out.println("\n=== Crear Nuevo Elemento DTI ===");
        System.out.println("Seleccione el tipo de elemento:");
        System.out.println("1. Computador");
        System.out.println("2. Control");
        System.out.println("3. Audiovisual");
        System.out.println("4. Accesorio");

        int tipoElemento = scanner.nextInt();
        scanner.nextLine(); // Limpiar buffer

        if (tipoElemento < 1 || tipoElemento > 4) {
            System.out.println("Tipo de elemento no válido");
            return;
        }

        System.out.print("Identificación: ");
        String identificacion = scanner.nextLine();
        System.out.print("Nombre: ");
        String nombre = scanner.nextLine();
        System.out.print("Descripción: ");
        String descripcion = scanner.nextLine();
        System.out.print("Ubicación: ");
        String ubicacion = scanner.nextLine();

        ElementosDti nuevoElemento = fabricas[tipoElemento - 1].crearElementoDti(
                identificacion,
                nombre,
                descripcion,
                ubicacion,
                EstadosElementos.DISPONIBLE,
                LocalDate.now()
        );

        elementosDTIService.crearElementoDti(nuevoElemento);
        System.out.println("Elemento creado exitosamente");
    }

    private void buscarElemento() {
        System.out.print("\nIngrese la identificación del elemento: ");
        String identificacion = scanner.next();

        Optional<ElementosDti> elemento = elementosDTIService.buscarPorIdentificacion(identificacion);
        if (elemento.isPresent()) {
            mostrarElemento(elemento.get());
        } else {
            System.out.println("Elemento no encontrado");
        }
    }

    private void actualizarElemento() {
        System.out.print("\nIngrese la identificación del elemento a actualizar: ");
        String identificacion = scanner.nextLine();

        Optional<ElementosDti> elementoExistente = elementosDTIService.buscarPorIdentificacion(identificacion);
        if (!elementoExistente.isPresent()) {
            System.out.println("Elemento no encontrado");
            return;
        }

        System.out.print("Nuevo nombre (Enter para mantener actual): ");
        String nombre = scanner.nextLine();
        if (!nombre.isEmpty()) {
            elementoExistente.get().setNombre(nombre);
        }

        System.out.print("Nueva descripción (Enter para mantener actual): ");
        String descripcion = scanner.nextLine();
        if (!descripcion.isEmpty()) {
            elementoExistente.get().setDescripcion(descripcion);
        }

        System.out.print("Nueva ubicación (Enter para mantener actual): ");
        String ubicacion = scanner.nextLine();
        if (!ubicacion.isEmpty()) {
            elementoExistente.get().setUbicacion(ubicacion);
        }

        elementosDTIService.actualizarElementoDti(identificacion, elementoExistente.get());
        System.out.println("Elemento actualizado exitosamente");
    }

    private void eliminarElemento() {
        System.out.print("\nIngrese la identificación del elemento a eliminar: ");
        String identificacion = scanner.nextLine();

        Optional<ElementosDti> elemento = elementosDTIService.buscarPorIdentificacion(identificacion);
        if (!elemento.isPresent()) {
            System.out.println("Elemento no encontrado");
            return;
        }

        System.out.print("¿Está seguro de eliminar este elemento? (S/N): ");
        String confirmacion = scanner.nextLine();
        if (confirmacion.equalsIgnoreCase("S")) {
            elementosDTIService.eliminarElementoDti(identificacion);
            System.out.println("Elemento eliminado exitosamente");
        }
    }

    private void listarElementos() {
        List<ElementosDti> elementos = elementosDTIService.listarTodos();
        if (elementos.isEmpty()) {
            System.out.println("\nNo hay elementos registrados");
            return;
        }

        System.out.println("\n=== Lista de Elementos DTI ===");
        for (ElementosDti elemento : elementos) {
            mostrarElemento(elemento);
            System.out.println("--------------------");
        }
    }

    private void mostrarElemento(ElementosDti elemento) {
        System.out.println("Identificación: " + elemento.getIdentificacion());
        System.out.println("Tipo: " + elemento.getTipo());
        System.out.println("Nombre: " + elemento.getNombre());
        System.out.println("Descripción: " + elemento.getDescripcion());
        System.out.println("Ubicación: " + elemento.getUbicacion());
        System.out.println("Estado: " + elemento.getEstado());
        System.out.println("Fecha de creación: " + elemento.getFechaCreacion());
    }
}

