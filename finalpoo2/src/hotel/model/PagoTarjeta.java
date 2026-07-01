package hotel.model;

public class PagoTarjeta implements EstrategiaPago {

    private String nroTarjeta;
    private String ccv;

    public PagoTarjeta() {
    }

    public PagoTarjeta(String nroTarjeta, String ccv) {
        this.nroTarjeta = nroTarjeta;
        this.ccv = ccv;
    }

    public String getNroTarjeta() {
        return nroTarjeta;
    }

    public void setNroTarjeta(String nroTarjeta) {
        this.nroTarjeta = nroTarjeta;
    }

    public String getCcv() {
        return ccv;
    }

    public void setCcv(String ccv) {
        this.ccv = ccv;
    }

    @Override
    public boolean procesarPago(double monto) {
        System.out.println("Pago con tarjeta: S/ " + monto);
        return true;
    }

}