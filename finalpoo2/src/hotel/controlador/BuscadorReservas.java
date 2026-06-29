package hotel.controlador;

import hotel.model.EstadoReserva;
import hotel.model.Reserva;

import java.util.ArrayList;
import java.util.List;

public class BuscadorReservas {

    public List<Reserva> filtrarReservasActivas(List<Reserva> reservas) {

        List<Reserva> activas = new ArrayList<>();

        for (Reserva reserva : reservas) {

            if (reserva.getEstado() == EstadoReserva.CONFIRMADA) {
                activas.add(reserva);
            }

        }

        return activas;
    }
}