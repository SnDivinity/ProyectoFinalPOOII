package hotel.controlador;

import hotel.builder.DirectorReserva;
import hotel.builder.ReservaEstandarBuilder;
import hotel.model.ComponenteHabitacion;
import hotel.model.EstrategiaPago;
import hotel.model.Huesped;
import hotel.model.Reserva;
import hotel.repositorio.ReservaRepositorio;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.List;

public class ReservaControlador {

    private ReservaRepositorio reservaRepositorio;
    private ProcesadorPagoRecurrente procesadorPago;
    private DirectorReserva directorReserva;

    public ReservaControlador() {

        this.reservaRepositorio = new ReservaRepositorio();
        this.procesadorPago = new ProcesadorPagoRecurrente();
        this.directorReserva = new DirectorReserva(new ReservaEstandarBuilder());
    }

    public Reserva crearReservaEstandar(int id,
                                     Huesped huesped,
                                     ComponenteHabitacion habitacion,
                                     LocalDate fechaInicio,
                                     LocalDate fechaFin) {

        Reserva reserva = directorReserva.construirReservaSimple(id, huesped, habitacion);

        reserva.setFechaInicio(fechaInicio);
        reserva.setFechaFin(fechaFin);

        long noches = ChronoUnit.DAYS.between(fechaInicio, fechaFin);
        if (noches < 1) {
            noches = 1;
        }
        reserva.setTotal(habitacion.getPrecioBase() * noches);

        reservaRepositorio.guardar(reserva);

        return reserva;
    }

    public List<Reserva> listarReservas() {
        return reservaRepositorio.buscarTodos();
    }

    public Reserva buscarPorId(int id) {
        return reservaRepositorio.buscarId(id);
    }

    public void pagarReserva(Reserva reserva, EstrategiaPago estrategiaPago) {

        if (estrategiaPago.procesarPago(reserva.getTotal())) {
            System.out.println("Pago realizado correctamente.");
        } else {
            System.out.println("No se pudo procesar el pago.");
        }
    }
}