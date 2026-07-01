package hotel.model;

public class Recepcionista extends Usuario {
    private String turno;
    private int nroCajaAsignada;

    public Recepcionista(String id, String nombre, String correo, String contrasena, String turno, int nroCajaAsignada) {
        super(id, nombre, correo, contrasena, RolUsuario.RECEPCIONISTA);
        this.turno = turno;
        this.nroCajaAsignada = nroCajaAsignada;
    }

    public String getTurno() { return turno; }
    public int getNroCajaAsignada() { return nroCajaAsignada; }
}