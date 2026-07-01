package hotel.model;

public class Salon {

    private int idSalon;
    private String nombre;
    private int capacidadMaxima;
    private double precioBase;
    private EstadoSalon estado;

    public Salon() {
    }

    public Salon(int idSalon, String nombre, int capacidadMaxima,
                 double precioBase, EstadoSalon estado) {
        this.idSalon = idSalon;
        this.nombre = nombre;
        this.capacidadMaxima = capacidadMaxima;
        this.precioBase = precioBase;
        this.estado = estado;
    }

    public int getIdSalon() {
        return idSalon;
    }

    public void setIdSalon(int idSalon) {
        this.idSalon = idSalon;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getCapacidadMaxima() {
        return capacidadMaxima;
    }

    public void setCapacidadMaxima(int capacidadMaxima) {
        this.capacidadMaxima = capacidadMaxima;
    }

    public double getPrecioBase() {
        return precioBase;
    }

    public void setPrecioBase(double precioBase) {
        this.precioBase = precioBase;
    }

    public EstadoSalon getEstado() {
        return estado;
    }

    public void setEstado(EstadoSalon estado) {
        this.estado = estado;
    }

    @Override
    public String toString() {
        return "Salon{" +
                "idSalon=" + idSalon +
                ", nombre='" + nombre + '\'' +
                ", capacidadMaxima=" + capacidadMaxima +
                ", precioBase=" + precioBase +
                ", estado=" + estado +
                '}';
    }
}