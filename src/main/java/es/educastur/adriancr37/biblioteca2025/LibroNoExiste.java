package es.educastur.adriancr37.biblioteca2025;

public class LibroNoExiste extends Exception {

    public LibroNoExiste(String cadena) {
        super(cadena); // Llama al constructor de Exceptions
    }
}
