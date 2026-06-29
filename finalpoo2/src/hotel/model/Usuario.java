package hotel.model;

public abstract class Usuario {
    protected String id;
    protected String nombre;
    protected String correo;
    protected String contrasena;
    protected RolUsuario rol;

    public Usuario(String id, String nombre, String correo, String contrasena, RolUsuario rol) {
        this.id = id;
        this.nombre = nombre;
        this.correo = correo;
        this.contrasena = contrasena;
        this.rol = rol;
    }

    // Getters y Setters
    public String getId() { return id; }
    public String getNombre() { return nombre; }
    public String getCorreo() { return correo; }
    public String getContrasena() { return contrasena; }
    public RolUsuario getRol() { return rol; }
}