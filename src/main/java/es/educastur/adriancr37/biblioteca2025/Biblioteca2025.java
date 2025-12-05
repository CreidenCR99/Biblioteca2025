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
    private static LocalDate hoy = LocalDate.now();

    public static void main(String[] args) {
        cargaDatos();
        menuPrincipal();
    }

    //#region CARGAR DATOS
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
    //#endregion

    //#region BUSCADORES
    public static int buscarLibro(String libro) {
        int pos = -1;
        int i = 0;
        for (Libro l : libros) {
            if (l.getIsbn().equalsIgnoreCase(libro)) {
                pos = i;
                break;
            }
            i++;
        }
        return pos;
    }

    public static int buscarUsuario(String usuario) {
        int pos = -1;
        int i = 0;
        for (Usuario u : usuarios) {
            if (u.getDni().equalsIgnoreCase(usuario)) {
                pos = i;
                break;
            }
            i++;
        }
        return pos;
    }
    //#endregion

    //#region MENUS
    public static void menuPrincipal() {
        int opcion;
        do {
            System.out.println("\n\tMENU DE OPCIONES");
            System.out.println("\t| 0 - SALIR");
            System.out.println("\t| 1 - GESTION LIBROS");
            System.out.println("\t| 2 - GESTION USUARIOS");
            System.out.println("\t| 3 - GESTION PRESTAMOS");
            System.out.println("\t| 4 - LISTADOS");

            System.out.print("Teclea el numero: ");

            opcion = sc.nextInt();
            System.out.println();

            switch (opcion) {
                // MENU DE OPCIONES
                case 1 -> {
                    menuLibros();
                }
                case 2 -> {
                    menuUsuarios();
                }
                case 3 -> {
                    menuPrestamos();
                }
                case 4 -> {
                    menuListados();
                }
            }
        } while (opcion != 0);
    }

    public static void menuLibros() {
        int opcion;
        do {
            System.out.println("\n\tMENU DE LIBROS");
            System.out.println("\t| 0 - SALIR");
            System.out.println("\t| 1 - AÑADIR LIBRO");
            System.out.println("\t| 2 - LISTADO DE LIBROS");
            System.out.println("\t| 3 - MODIFICAR LIBRO");
            System.out.println("\t| 4 - ELIMINAR LIBRO");

            System.out.print("Teclea el numero: ");

            opcion = sc.nextInt();
            System.out.println();

            switch (opcion) {
                // MENU DE OPCIONES
                case 1 -> {
                    crearLibro();
                    sc.nextLine();
                }
                case 2 -> {
                    listarLibros();
                }
                case 3 -> {
                    modificarLibro();
                }
                case 4 -> {
                    eliminarLibro();
                }
            }
        } while (opcion != 0);
    }

    public static void menuUsuarios() {
        int opcion;
        do {
            System.out.println("\n\tMENU DE USUARIOS");
            System.out.println("\t| 0 - SALIR");
            System.out.println("\t| 1 - REGISTRAR USUARIO");
            System.out.println("\t| 2 - LISTADO DE USUARIOS");
            System.out.println("\t| 3 - MODIFICAR USUARIO");
            System.out.println("\t| 4 - ELIMINAR USUARIO");

            System.out.print("Teclea el numero: ");

            opcion = sc.nextInt();
            System.out.println();

            switch (opcion) {
                // MENU DE OPCIONES
                case 1 -> {
                    crearUsuario();
                }
                case 2 -> {
                    listarUsuarios();
                }
                case 3 -> {
                    modificarUsuario();
                }
                case 4 -> {
                    eliminarUsuario();
                }
            }
        } while (opcion != 0);
    }

    public static void menuPrestamos() {
        int opcion;
        do {
            System.out.println("\n\tMENU DE PRESTAMOS");
            System.out.println("\t| 0 - SALIR");
            System.out.println("\t| 1 - PRESTAMO");
            System.out.println("\t| 2 - DEVOLUCION");

            System.out.print("Teclea el numero: ");

            opcion = sc.nextInt();
            System.out.println();

            switch (opcion) {
                // MENU DE OPCIONES
                case 1 -> {
                    crearPrestamo();
                }
                case 2 -> {
                    eliminarPrestamo(); // Crear devolucion
                }
            }
        } while (opcion != 0);
    }

    public static void menuListados() {
        int opcion;
        do {
            System.out.println("\n\tMENU DE LISTADOS");
            System.out.println("\t| 0 - SALIR");
            System.out.println("\t| 1 - LISTADO DE USUARIOS");
            System.out.println("\t| 2 - LISTADO DE LIBROS");
            System.out.println("\t| 3 - LISTADO DE PRESTAMOS");

            System.out.print("Teclea el numero: ");

            opcion = sc.nextInt();
            System.out.println();

            switch (opcion) {
                // MENU DE OPCIONES
                case 1 -> {
                    listarUsuarios();
                }
                case 2 -> {
                    listarLibros();
                }
                case 3 -> {
                    listarPrestamos();
                }
            }
        } while (opcion != 0);
    }

    //#endregion

    //#region CREAR
    public static void crearLibro() {
        System.out.println("Vamos a registrar un libro nuevo");
        System.out.print("Escribe el ISBN del libro: ");
        String isbn = sc.next();
        System.out.print("Escribe el titulo: ");
        sc.nextLine();
        String titulo = sc.nextLine();
        System.out.print("Escribe el nombre del autor: ");
        String autor = sc.nextLine();
        System.out.print("Escribe el genero del libro: ");
        String genero = sc.nextLine();
        System.out.print("Escribe la cantidad de ejemplares: ");
        int ejemplares = sc.nextInt();
        libros.add(new Libro(isbn, titulo, autor, genero, ejemplares));
    }

    public static void crearUsuario() {
        System.out.println("Vamos a registrar un usuario nuevo");
        System.out.print("Escribe el DNI del usuario: ");
        String dni = sc.next();
        System.out.print("Escribe el nombre: ");
        String nombre = sc.next();
        System.out.print("Escribe el email: ");
        String email = sc.next();
        System.out.print("Escribe el telefono: ");
        String telefono = sc.next();
        usuarios.add(new Usuario(dni, nombre, email, telefono));
    }

    public static void crearPrestamo() {
        System.out.println("Vamos a hacer un prestamo");
        System.out.print("Escribe el ISBN del libro: ");
        String libroPrest = sc.next();
        int libroPos = buscarLibro(libroPrest);
        if (libroPos == -1) {
            System.out.println("Ese libro no existe en la biblioteca");
        } else {
            System.out.print("Escribe el DNI del usuario: ");
            String usuarioPrest = sc.next();
            int usuarioPos = buscarUsuario(usuarioPrest);
            if (usuarioPos == -1) {
                System.out.println("Ese usuario no esta registrado");
            } else {
                buscarUsuario(usuarioPrest);
                LocalDate fechaPrest = hoy;
                LocalDate fechaDev = hoy.plusDays(7);
                prestamos.add(new Prestamo(libros.get(libroPos), usuarios.get(usuarioPos), fechaPrest, fechaDev));
            }
        }
    }
//#endregion

    //#region LISTAR
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
    //#endregion

    //#region MODIFICAR
    public static void modificarLibro() {

    }

    public static void modificarUsuario() {

    }
    //#endregion

    //#region ELIMINAR
    public static void eliminarLibro() {

    }

    public static void eliminarUsuario() {

    }

    public static void eliminarPrestamo() {

    }
    //#endregion
}
