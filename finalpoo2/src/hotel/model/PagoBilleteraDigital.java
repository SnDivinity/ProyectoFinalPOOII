package hotel.model;

public class PagoBilleteraDigital implements EstrategiaPago {

    private String billeteraDigital;

    public PagoBilleteraDigital() {
    }

    public PagoBilleteraDigital(String billeteraDigital) {
        this.billeteraDigital = billeteraDigital;
    }

    public String getBilleteraDigital() {
        return billeteraDigital;
    }

    public void setBilleteraDigital(String billeteraDigital) {
        this.billeteraDigital = billeteraDigital;
    }

    @Override
    public boolean procesarPago(double monto) {
        System.out.println("Pago mediante " + billeteraDigital + ": S/ " + monto);
        return true;
    }

}