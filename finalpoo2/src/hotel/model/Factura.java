package hotel.model;

public class Factura {

    private String nroFactura;
    private int reservaId;
    private double montoTotal;

    public Factura() {
    }

    public Factura(String nroFactura, int reservaId, double montoTotal) {
        this.nroFactura = nroFactura;
        this.reservaId = reservaId;
        this.montoTotal = montoTotal;
    }

    public String getNroFactura() {
        return nroFactura;
    }

    public void setNroFactura(String nroFactura) {
        this.nroFactura = nroFactura;
    }

    public int getReservaId() {
        return reservaId;
    }

    public void setReservaId(int reservaId) {
        this.reservaId = reservaId;
    }

    public double getMontoTotal() {
        return montoTotal;
    }

    public void setMontoTotal(double montoTotal) {
        this.montoTotal = montoTotal;
    }

}