package hotel.model;

public class DescuentoNulo implements EvaluadorDescuento {

    @Override
    public double aplicarDescuento(double subtotal) {
        return subtotal;
    }

}