package hotel.vista;

import hotel.model.Enum.EstadoHabitacion;
import hotel.model.observer.HabitacionesObserver;

public class HabitacionesVista implements HabitacionesObserver {

    @Override
    public void actualizarEstado(int numeroHabitacion,
                                 EstadoHabitacion nuevoEstado) {

        System.out.println(
                "Habitación "
                        + numeroHabitacion
                        + " -> "
                        + nuevoEstado);

    }

    public void mostrarMensaje(String mensaje) {
        System.out.println(mensaje);
    }
}