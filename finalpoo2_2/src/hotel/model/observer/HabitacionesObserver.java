package hotel.model.observer;

import hotel.model.Enum.EstadoHabitacion;

public interface HabitacionesObserver {

    void actualizarEstado(int numeroHabitacion,
                          EstadoHabitacion nuevoEstado);

}