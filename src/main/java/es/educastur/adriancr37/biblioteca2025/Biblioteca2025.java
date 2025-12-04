package es.educastur.adriancr37.biblioteca2025;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Biblioteca2025
 *
 * @author 1dawd09
 * @version 1.0
 */
public class Biblioteca2025 {

    private static Scanner sc = new Scanner(System.in);
    private static ArrayList<Libro> libros = new ArrayList();
    private static ArrayList<Usuario> usuarios = new ArrayList();
    private static ArrayList<Prestamo> prestamos = new ArrayList();

    public static void main(String[] args) {
        cargaDatos();
        listar();
    }

    public static void cargaDatos() {
        cargaLibros();
        cargaUsuarios();
        cargaPrestamos();
    }
    public static void cargaLibros() {
        libros.add(new Libro("1-11", "El Hobbit", "JRR Tolkien", "Aventuras", 3));
        libros.add(new Libro("1-22", "El Silmarillon", "JRR Tolkien", "Aventuras", 3));
        libros.add(new Libro("1-33", "El Medico", "N. Gordon", "Aventuras", 4));
        libros.add(new Libro("1-44", "Chaman", "N. Gordon", "Aventuras", 3));
        libros.add(new Libro("1-55", "Momo", "M. Ende", "Aventuras", 2));
        libros.add(new Libro("1-66", "Paraiso inhabitado", "A.M.Matute", "Aventuras", 2));
        libros.add(new Libro("1-77", "Olvidado Rey Gudu", "A.M.Matute", "Aventuras", 0));
        libros.add(new Libro("1-88", "El ultimo barco", "D.Villar", "Novela Negra", 3));
        libros.add(new Libro("1-99", "Ojos de agua", "D.Villar", "Novela Negra", 0));
    }
    public static void cargaUsuarios() {
        usuarios.add(new Usuario("11", "Ana", "ana@email.com", "621111111"));
        usuarios.add(new Usuario("22", "David", "david@email.com", "622222222"));
        usuarios.add(new Usuario("33", "Bea", "bea@email.com", "623333333"));
        usuarios.add(new Usuario("44", "Lucas", "lucas@email.com", "624444444"));
        usuarios.add(new Usuario("55", "Carlota", "carlota@email.com", "625555555"));
        usuarios.add(new Usuario("66", "Juan", "juan@email.com", "626666666"));
    }
    public static void cargaPrestamos() {
        LocalDate hoy = LocalDate.now();
        prestamos.add(new Prestamo(libros.get(0), usuarios.get(0), hoy.minusDays(20), hoy.minusDays(5)));
        prestamos.add(new Prestamo(libros.get(0), usuarios.get(0), hoy, hoy.plusDays(15)));
        prestamos.add(new Prestamo(libros.get(5), usuarios.get(0), hoy, hoy.plusDays(15)));
        prestamos.add(new Prestamo(libros.get(5), usuarios.get(0), hoy.minusDays(20), hoy.minusDays(5)));
        prestamos.add(new Prestamo(libros.get(1), usuarios.get(4), hoy.minusDays(20), hoy.minusDays(5)));
        prestamos.add(new Prestamo(libros.get(2), usuarios.get(4), hoy.minusDays(20), hoy.minusDays(5)));
        prestamos.add(new Prestamo(libros.get(3), usuarios.get(4), hoy.minusDays(20), hoy.minusDays(5)));
        prestamos.add(new Prestamo(libros.get(6), usuarios.get(4), hoy, hoy.plusDays(2)));
        prestamos.add(new Prestamo(libros.get(6), usuarios.get(1), hoy, hoy.plusDays(5)));
    }

    public static void listar() {
        System.out.println("\n\tLibros\n");
        listarLibros();
        System.out.println("\n\tUsuarios\n");
        listarUsuarios();
        System.out.println("\n\tPrestamos\n");
        listarPrestamos();
    }

    public static void listarLibros() {
        for (Libro l : libros) {
            System.out.print(l.getIsbn() == null ? "" : l.getIsbn() + "-");
            System.out.print(l.getTitulo() == null ? "" : l.getTitulo() + "-");
            System.out.print(l.getAutor() == null ? "" : l.getAutor() + "-");
            System.out.print(l.getGenero() == null ? "" : l.getGenero() + "-");
            System.out.print(l.getEjemplares() + "");
            System.out.println();
        }
    }
    public static void listarUsuarios() {
        for (Usuario u : usuarios) {
            System.out.print(u.getDni() == null ? "" : u.getDni() + "-");
            System.out.print(u.getNombre() == null ? "" : u.getNombre() + "-");
            System.out.print(u.getEmail() == null ? "" : u.getEmail() + "-");
            System.out.print(u.getTelefono() == null ? "" : u.getTelefono() + "");
            System.out.println();
        }
    }
    public static void listarPrestamos() {
        for (Prestamo p : prestamos) {
            System.out.print(p.getLibroPrest() == null ? "" : p.getLibroPrest() + "-");
            System.out.print(p.getUsuarioPrest() == null ? "" : p.getUsuarioPrest() + "-");
            System.out.print(p.getFechaPrest() == null ? "" : p.getFechaPrest() + "-");
            System.out.print(p.getFechaDev() == null ? "" : p.getFechaDev() + "");
            System.out.println();
        }
    }
}
