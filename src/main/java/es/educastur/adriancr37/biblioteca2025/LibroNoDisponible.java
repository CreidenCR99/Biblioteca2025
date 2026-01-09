package es.educastur.adriancr37.biblioteca2025;

public class LibroNoDisponible extends Exception {

    public LibroNoDisponible(String cadena) {
        super(cadena); // Llama al constructor de Exceptions
    }
}
