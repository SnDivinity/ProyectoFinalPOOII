package hotel.model;

public class DescuentoCorporativo implements EvaluadorDescuento {

    @Override
    public double aplicarDescuento(double subtotal) {
        return subtotal * 0.90; //10% de descuento
    }

}