package hotel.builder;

import hotel.model.*;

import java.time.LocalDate;

public class ReservaVipBuilder implements IReservaBuilder {

    private Reserva reservaEnProceso;

    public ReservaVipBuilder() {
        reservaEnProceso = new Reserva();
    }

    @Override
    public IReservaBuilder iniciarReserva(int id) {
        reservaEnProceso.setIdReserva(id);
        return this;
    }

    @Override
    public IReservaBuilder asignarHuesped(Huesped huesped) {
        reservaEnProceso.setHuesped(huesped);
        return this;
    }

    @Override
    public IReservaBuilder agregarHabitacion(ComponenteHabitacion habitacion) {
        reservaEnProceso.agregarHabitacion(habitacion);
        return this;
    }

    @Override
    public IReservaBuilder definirFechas(LocalDate inicio, LocalDate fin) {
        reservaEnProceso.setFechaInicio(inicio);
        reservaEnProceso.setFechaFin(fin);
        return this;
    }

    @Override
    public Reserva build() {

        reservaEnProceso.setTotal(
                reservaEnProceso.getTotal() * 0.90
        );

        return reservaEnProceso;
    }
}