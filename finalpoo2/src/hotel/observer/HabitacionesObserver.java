package hotel.observer;

import hotel.model.EstadoHabitacion;

public interface HabitacionesObserver {

    void actualizarEstado(int numeroHabitacion,
                          EstadoHabitacion nuevoEstado);

}