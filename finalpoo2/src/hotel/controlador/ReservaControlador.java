package hotel.controlador;

import hotel.model.builder.DirectorReserva;
import hotel.model.ComponenteHabitacion;
import hotel.model.EstrategiaPago;
import hotel.model.Huesped;
import hotel.model.Reserva;
import hotel.model.repositorio.ReservaRepositorio;

import java.time.LocalDate;

public class ReservaControlador {

    private ReservaRepositorio reservaRepositorio;
    private ProcesadorPagoRecurrente procesadorPago;
    private DirectorReserva directorReserva;

    public ReservaControlador(ReservaRepositorio reservaRepositorio,
                              ProcesadorPagoRecurrente procesadorPago,
                              DirectorReserva directorReserva) {

        this.reservaRepositorio = reservaRepositorio;
        this.procesadorPago = procesadorPago;
        this.directorReserva = directorReserva;
    }

    public void crearReservaEstandar(int id,
                                     Huesped huesped,
                                     ComponenteHabitacion habitacion,
                                     LocalDate fechaInicio,
                                     LocalDate fechaFin) {

        Reserva reserva = directorReserva.construirReservaSimple(id, huesped, habitacion);

        reserva.setFechaInicio(fechaInicio);
        reserva.setFechaFin(fechaFin);

        reservaRepositorio.guardar(reserva);
    }

    public void pagarReserva(Reserva reserva, EstrategiaPago estrategiaPago) {

        if (estrategiaPago.procesarPago(reserva.getTotal())) {
            System.out.println("Pago realizado correctamente.");
        } else {
            System.out.println("No se pudo procesar el pago.");
        }
    }
}