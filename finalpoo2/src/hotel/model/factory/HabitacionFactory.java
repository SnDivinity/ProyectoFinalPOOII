package hotel.model.factory;

import hotel.model.ComponenteHabitacion;

public interface HabitacionFactory {

    ComponenteHabitacion crearHabitacion(int numero,
                                         double precioBase);

}