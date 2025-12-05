package es.educastur.adriancr37.biblioteca2025;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Biblioteca2025
 *
 * @author 1dawd09
 * @version 1.1
 */
public class Biblioteca2025 {

    @SuppressWarnings("FieldMayBeFinal")
    private static Scanner sc = new Scanner(System.in);
    @SuppressWarnings({"FieldMayBeFinal", "rawtypes", "unchecked"})
    private static ArrayList<Libro> libros = new ArrayList();
    @SuppressWarnings({"FieldMayBeFinal", "rawtypes", "unchecked"})
    private static ArrayList<Usuario> usuarios = new ArrayList();
    @SuppressWarnings({"FieldMayBeFinal", "rawtypes", "unchecked"})
    private static ArrayList<Prestamo> prestamos = new ArrayList();
    @SuppressWarnings({"FieldMayBeFinal"})
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
                    menuModificarLibro();
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
                    menuModificarUsuario();
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
            System.out.println("\t| 1 - LISTADO DE LIBROS");
            System.out.println("\t| 2 - LISTADO DE USUARIOS");
            System.out.println("\t| 3 - LISTADO DE PRESTAMOS");

            System.out.print("Teclea el numero: ");

            opcion = sc.nextInt();
            System.out.println();

            switch (opcion) {
                // MENU DE OPCIONES
                case 1 -> {
                    listarLibros();
                }
                case 2 -> {
                    listarUsuarios();
                }
                case 3 -> {
                    listarPrestamos();
                }
            }
        } while (opcion != 0);
    }

    //#region MENUS MODIFICAR
    public static void menuModificarLibro() {
        System.out.print("Escribe el ISBN del libro a modificar: ");
        int libroPos = buscarLibro(sc.next());
        if (libroPos == -1) {
            System.out.println("El libro no existe.");
            return;
        }
        Libro l = libros.get(libroPos);
        System.out.println("Titulo:\t" + l.getTitulo());
        System.out.println("Autor:\t" + l.getAutor());
        System.out.println("Genero:\t" + l.getGenero());
        System.out.println("Ejemplares:\t" + l.getEjemplares());
        int opcion;
        do {
            System.out.println("\n\tMENU DE MODIFICAR LIBROS");
            System.out.println("\t| 0 - SALIR");
            System.out.println("\t| 1 - ISBN");
            System.out.println("\t| 2 - TITULO");
            System.out.println("\t| 3 - AUTOR");
            System.out.println("\t| 4 - GENERO");
            System.out.println("\t| 5 - EJEMPLARES");

            System.out.print("Teclea el numero: ");

            opcion = sc.nextInt();
            System.out.println();

            switch (opcion) {
                // MENU DE OPCIONES
                case 1 -> {
                    System.out.println("Se va a modificar el ISBN: " + l.getIsbn());
                    System.out.print("Escribe el nuevo ISBN: ");
                    l.setIsbn(sc.next());
                }
                case 2 -> {
                    System.out.println("Se va a modificar el titulo: " + l.getTitulo());
                    System.out.print("Escribe el nuevo titulo: ");
                    sc.nextLine();
                    l.setTitulo(sc.nextLine());
                }
                case 3 -> {
                    System.out.println("Se va a modificar el autor: " + l.getTitulo());
                    System.out.print("Escribe el nuevo autor: ");
                    l.setAutor(sc.next());
                }
                case 4 -> {
                    System.out.println("Se va a modificar el genero: " + l.getGenero());
                    System.out.print("Escribe el nuevo autor: ");
                    l.setGenero(sc.next());
                }
                case 5 -> {
                    System.out.println("Se va a modificar la cantidad de ejemplares: " + l.getEjemplares());
                    System.out.print("Escribe la cantidad de ejemplares: ");
                    sc.nextLine();
                    l.setEjemplares(sc.nextInt());
                }
            }
        } while (opcion != 0);
    }

    public static void menuModificarUsuario() {
        System.out.print("Escribe el DNI del usuario a modificar: ");
        int usuarioPos = buscarUsuario(sc.next());
        if (usuarioPos == -1) {
            System.out.println("El usuario no existe.");
            return;
        }
        Usuario u = usuarios.get(usuarioPos);
        System.out.println("Nombre:\t" + u.getNombre());
        System.out.println("Email:\t" + u.getEmail());
        System.out.println("Telefono:\t" + u.getTelefono());
        int opcion;
        do {
            System.out.println("\n\tMENU DE MODIFICAR USUARIOS");
            System.out.println("\t| 0 - SALIR");
            System.out.println("\t| 1 - DNI");
            System.out.println("\t| 2 - NOMBRE");
            System.out.println("\t| 3 - EMAIL");
            System.out.println("\t| 4 - TELEFONO");

            System.out.print("Teclea el numero: ");

            opcion = sc.nextInt();
            System.out.println();

            switch (opcion) {
                // MENU DE OPCIONES
                case 1 -> {
                    System.out.println("Se va a modificar el DNI: " + u.getDni());
                    System.out.print("Escribe el nuevo DNI: ");
                    u.setDni(sc.next());
                }
                case 2 -> {
                    System.out.println("Se va a modificar el nombre: " + u.getNombre());
                    System.out.print("Escribe el nuevo nombre: ");
                    u.setNombre(sc.next());
                }
                case 3 -> {
                    System.out.println("Se va a modificar el email: " + u.getEmail());
                    System.out.print("Escribe el nuevo email: ");
                    u.setEmail(sc.next());
                }
                case 4 -> {
                    System.out.println("Se va a modificar el telefono: " + u.getTelefono());
                    System.out.print("Escribe el nuevo telefono: ");
                    u.setTelefono(sc.next());
                }
            }
        } while (opcion != 0);
    }

    public static void menuModificarPrestamos() {
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
            Libro libro = libros.get(libroPos);
            if (libro.getEjemplares() <= 0) {
                System.out.println("No quedan ejemplares disponibles de este libro.");
                return;
            }
            System.out.print("Escribe el DNI del usuario: ");
            String usuarioPrest = sc.next();
            int usuarioPos = buscarUsuario(usuarioPrest);
            if (usuarioPos == -1) {
                System.out.println("Ese usuario no esta registrado");
            } else {
                LocalDate fechaPrest = hoy;
                LocalDate fechaDev = hoy.plusDays(7);
                prestamos.add(new Prestamo(libro, usuarios.get(usuarioPos), fechaPrest, fechaDev));
                libro.setEjemplares(libro.getEjemplares() - 1);
                System.out.println("Prestamo realizado correctamente. Quedan " + libro.getEjemplares() + " ejemplares.");
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

    //#region ELIMINAR
    public static void eliminarLibro() {
        System.out.print("Escribe el ISBN del libro a eliminar: ");
        int libroPos = buscarLibro(sc.next());
        if (libroPos == -1) {
            System.out.println("El libro no existe.");
            return;
        }
        Libro l = libros.get(libroPos);
        System.out.println("Titulo:\t" + l.getTitulo());
        System.out.println("Autor:\t" + l.getAutor());
        System.out.println("Genero:\t" + l.getGenero());
        System.out.println("Ejemplares:\t" + l.getEjemplares());
        System.out.println("¿Esta informacion es correcta y deseas eliminar el libro? (Si/No)");
        if (sc.next().equalsIgnoreCase("Si")) {
            libros.remove(libroPos);
        }
    }

    public static void eliminarUsuario() {
        System.out.print("Escribe el DNI del usuario a eliminar: ");
        int usuarioPos = buscarUsuario(sc.next());
        if (usuarioPos == -1) {
            System.out.println("El usuario no existe.");
            return;
        }
        Usuario u = usuarios.get(usuarioPos);
        System.out.println("Nombre:\t" + u.getNombre());
        System.out.println("Email:\t" + u.getEmail());
        System.out.println("Telefono:\t" + u.getTelefono());
        System.out.println("¿Esta informacion es correcta y deseas eliminar el usuario? (Si/No)");
        if (sc.next().equalsIgnoreCase("Si")) {
            usuarios.remove(usuarioPos);
        }
    }

    public static void eliminarPrestamo() {

    }
    //#endregion
}

// <editor-fold defaultstate="collapse" desc="MENU">

// </editor-fold>
