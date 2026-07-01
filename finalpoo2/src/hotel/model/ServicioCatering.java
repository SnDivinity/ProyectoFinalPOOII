package hotel.model;

public class ServicioCatering {

    private String tipoMenu;
    private double precioPorPersona;

    public ServicioCatering() {
    }

    public ServicioCatering(String tipoMenu, double precioPorPersona) {
        this.tipoMenu = tipoMenu;
        this.precioPorPersona = precioPorPersona;
    }

    public String getTipoMenu() {
        return tipoMenu;
    }

    public void setTipoMenu(String tipoMenu) {
        this.tipoMenu = tipoMenu;
    }

    public double getPrecioPorPersona() {
        return precioPorPersona;
    }

    public void setPrecioPorPersona(double precioPorPersona) {
        this.precioPorPersona = precioPorPersona;
    }

    public double calcularCostoTotalCatering(int asistentes) {
        return asistentes * precioPorPersona;
    }

    public void cambiarMenu(String nuevoMenu, double nuevoPrecio) {
        this.tipoMenu = nuevoMenu;
        this.precioPorPersona = nuevoPrecio;
    }

}