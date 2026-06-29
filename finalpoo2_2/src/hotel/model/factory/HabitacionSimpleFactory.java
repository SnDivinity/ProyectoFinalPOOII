package hotel.model.factory;

import hotel.model.ComponenteHabitacion;
import hotel.model.Habitacion;
import hotel.model.Enum.TipoHabitacion;

public class HabitacionSimpleFactory implements HabitacionFactory {

    @Override
    public ComponenteHabitacion crearHabitacion(int numero, double precioBase) {
        return new Habitacion(numero, precioBase, TipoHabitacion.SIMPLE);
    }
}