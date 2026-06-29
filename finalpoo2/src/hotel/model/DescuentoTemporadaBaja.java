package hotel.model;

public class DescuentoTemporadaBaja implements EvaluadorDescuento {

    @Override
    public double aplicarDescuento(double subtotal) {
        return subtotal * 0.85; // 15% de descuento
    }

}