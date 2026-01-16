package es.educastur.adriancr37.biblioteca2025;

public class Usuario {

    private String dni;
    private String nombre;
    private String email;
    private String telefono;

    public Usuario(String dni, String nombre, String email, String telefono) {
        this.dni = dni;
        this.nombre = nombre;
        this.email = email;
        this.telefono = telefono;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    @Override
    public String toString() {
        return "DNI:\t" + dni
        + "\n" + "Nombre:\t" + nombre
        + "\n" + "Email:\t" + email
        + "\n" + "Telefono:\t" + telefono;
    }

    public String toStringShort() {
        return "DNI:\t" + dni
        + " - " + "Nombre:\t" + nombre
        + " - " + "Email:\t" + email
        + " - " + "Telefono:\t" + telefono;
    }
}
