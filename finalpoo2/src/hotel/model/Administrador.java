package hotel.model;

public class Administrador extends Usuario {
    private int nivelAcceso;

    public Administrador(String id, String nombre, String correo, String contrasena, int nivelAcceso) {
        super(id, nombre, correo, contrasena, RolUsuario.ADMINISTRADOR);
        this.nivelAcceso = nivelAcceso;
    }

    public int getNivelAcceso() { return nivelAcceso; }
}