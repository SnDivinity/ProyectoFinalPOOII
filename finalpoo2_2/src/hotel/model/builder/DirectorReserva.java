package hotel.model.builder;

import hotel.model.*;

public class DirectorReserva {

    private IReservaBuilder builder;

    public DirectorReserva(IReservaBuilder builder) {
        this.builder = builder;
    }

    public Reserva construirReservaSimple(int id,
                                          Huesped h,
                                          ComponenteHabitacion c) {

        return builder
                .iniciarReserva(id)
                .asignarHuesped(h)
                .agregarHabitacion(c)
                .build();

    }

}