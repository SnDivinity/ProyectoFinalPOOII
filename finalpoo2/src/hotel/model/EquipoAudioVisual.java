package hotel.model;

public class EquipoAudioVisual {

    private String descripcion;
    private double costoAlquiler;

    public EquipoAudioVisual() {
    }

    public EquipoAudioVisual(String descripcion, double costoAlquiler) {
        this.descripcion = descripcion;
        this.costoAlquiler = costoAlquiler;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public double getCostoAlquiler() {
        return costoAlquiler;
    }

    public void setCostoAlquiler(double costoAlquiler) {
        this.costoAlquiler = costoAlquiler;
    }

    public double aplicarRecargoPorHorasExtras(int horas) {
        return costoAlquiler * horas;
    }

}