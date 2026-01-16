package es.educastur.adriancr37.biblioteca2025;

import java.time.LocalDate;

public class Prestamo {

    private Libro libroPrest;
    private Usuario usuarioPrest;
    private LocalDate fechaPrest;
    private LocalDate fechaDev;

    public Prestamo(Libro libroPrest, Usuario usuarioPrest, LocalDate fechaPrest, LocalDate fechaDev) {
        this.libroPrest = libroPrest;
        this.usuarioPrest = usuarioPrest;
        this.fechaPrest = fechaPrest;
        this.fechaDev = fechaDev;
    }

    public Libro getLibroPrest() {
        return libroPrest;
    }

    public void setLibroPrest(Libro libroPrest) {
        this.libroPrest = libroPrest;
    }

    public Usuario getUsuarioPrest() {
        return usuarioPrest;
    }

    public void setUsuarioPrest(Usuario usuarioPrest) {
        this.usuarioPrest = usuarioPrest;
    }

    public LocalDate getFechaPrest() {
        return fechaPrest;
    }

    public void setFechaPrest(LocalDate fechaPrest) {
        this.fechaPrest = fechaPrest;
    }

    public LocalDate getFechaDev() {
        return fechaDev;
    }

    public void setFechaDev(LocalDate fechaDev) {
        this.fechaDev = fechaDev;
    }

    @Override
    public String toString() {
        return "Libro:\t" + libroPrest.getIsbn() + " - " + libroPrest.getTitulo() + " - " + libroPrest.getAutor() + " - " + libroPrest.getGenero() + " - " + libroPrest.getEjemplares()
        + "\n" + "Usuario:\t" + usuarioPrest.getNombre() + " - " + usuarioPrest.getDni() + " - " + usuarioPrest.getEmail() + " - " + usuarioPrest.getTelefono()
        + "\n" + "Fecha de prestamo:\t" + fechaPrest
        + "\n" + "Fecha de devolución:\t" + fechaDev;
    }

    public String toStringShort() {
        return "Libro:\t" + libroPrest.getIsbn() + " - " + libroPrest.getTitulo()
        + "\n" + "Usuario:\t" + usuarioPrest.getNombre() + " - " + usuarioPrest.getDni() + " - " + usuarioPrest.getEmail()
        + "\n" + "Fecha de prestamo:\t" + fechaPrest
        + "\n" + "Fecha de devolución:\t" + fechaDev;
    }
}
