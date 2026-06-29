package hotel.model;

public class PersonalLimpieza {

    private int idPersonal;
    private String nombre;
    private boolean disponible;

    public PersonalLimpieza(int idPersonal, String nombre, boolean disponible) {
        this.idPersonal = idPersonal;
        this.nombre = nombre;
        this.disponible = disponible;
    }

    public int getIdPersonal() {
        return idPersonal;
    }

    public void setIdPersonal(int idPersonal) {
        this.idPersonal = idPersonal;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public boolean isDisponible() {
        return disponible;
    }

    public void setDisponible(boolean disponible) {
        this.disponible = disponible;
    }

    @Override
    public String toString() {
        return "PersonalLimpieza{" +
                "idPersonal=" + idPersonal +
                ", nombre='" + nombre + '\'' +
                ", disponible=" + disponible +
                '}';
    }
}