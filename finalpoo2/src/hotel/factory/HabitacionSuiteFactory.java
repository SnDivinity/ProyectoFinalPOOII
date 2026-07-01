package hotel.factory;

import hotel.model.ComponenteHabitacion;
import hotel.model.Habitacion;
import hotel.model.TipoHabitacion;

public class HabitacionSuiteFactory implements HabitacionFactory {

    @Override
    public ComponenteHabitacion crearHabitacion(int numero, double precioBase) {
        return new Habitacion(numero, precioBase, TipoHabitacion.SUITE);
    }
}