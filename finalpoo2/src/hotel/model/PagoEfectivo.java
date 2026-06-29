package hotel.model;

public class PagoEfectivo implements EstrategiaPago {

    @Override
    public boolean procesarPago(double monto) {
        System.out.println("Pago en efectivo: S/ " + monto);
        return true;
    }

}