package hotel.builder;

import hotel.model.*;

import java.time.LocalDate;

public interface IReservaBuilder {

    IReservaBuilder iniciarReserva(int id);

    IReservaBuilder asignarHuesped(Huesped huesped);

    IReservaBuilder agregarHabitacion(ComponenteHabitacion habitacion);

    IReservaBuilder definirFechas(LocalDate inicio, LocalDate fin);

    Reserva build();

}